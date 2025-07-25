package com.example.springbootfirst.services;

import com.example.springbootfirst.jwt.JwtTokenProvider;
import com.example.springbootfirst.models.JwtResponse;
import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.Roles;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import com.example.springbootfirst.repository.RegisterRepository;
import com.example.springbootfirst.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthService {

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RegisterDetailsRepository regRepo;

    @Autowired
    private RolesRepository roleRepo;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    PasswordEncoder passwordEncoder;



    public List<RegisterDetails> getRegisterDetails() {
        return regRepo.findAll();
    }

    public String addNewUser(UserDetailsDto register) {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setEmpName(register.getName()); // ✅ Add this line
        registerDetails.setUserName(register.getUserName()); // ✅ Properly set userName
        registerDetails.setEmail(register.getEmail());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));

        Set<Roles> roles = new HashSet<>();

        if (register.getRoleName() != null) {
            for (String roleName : register.getRoleName()) {
                Roles role = roleRepo.findByroleName(roleName)
                        .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
                roles.add(role);
            }
        } else {
            throw new RuntimeException("Roles must not be null");
        }

        registerDetails.setRoles(roles);


        regRepo.save(registerDetails);
        return "User registered successfully!";
    }


    public JwtResponse loginUser(RegisterDetails login) {
        Authentication authentication =
                authenticationManager.authenticate(//it calls authenticate method in authenticatemanager interface which gets credentials as argumnt
                        new UsernamePasswordAuthenticationToken(
                                login.getUserName(), login.getPassword()
                        )
                );
        String token = jwtTokenProvider.generateToken(authentication); //23CS124

        // Extract username
        String username = login.getUserName();

        // Extract roles
        List<String> roles = authentication.getAuthorities().stream()
                .map(role -> role.getAuthority())
                .collect(Collectors.toList());

        String joinedRoles = String.join(",", roles);

        return new JwtResponse(token, username, joinedRoles);

    }


    public Optional<RegisterDetails> findByUserByUsername(String userName) {
        return regRepo.findByUserName(userName);
    }

}