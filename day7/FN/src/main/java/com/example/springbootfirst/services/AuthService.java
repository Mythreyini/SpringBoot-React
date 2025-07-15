package com.example.springbootfirst.services;


import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.Roles;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import com.example.springbootfirst.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthService {
    @Autowired
    RegisterDetailsRepository registerDetailsRepository;
    @Autowired
    RolesRepository rolesRepository;


    @Autowired
    PasswordEncoder passwordEncoder;


    //post
    public String addNewService(UserDetailsDto register) {
        RegisterDetails registerDetails = new RegisterDetails();

        // Set basic fields
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setEmpName(register.getName());
        registerDetails.setUserName(register.getUserName());

        // Encode the password before storing
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));

        // Fetch and assign roles
        Set<Roles> roles = new HashSet<>();
        for (String roleName : register.getRoleName()) {
            Roles role = rolesRepository.findByroleName(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
            roles.add(role);
        }
        registerDetails.setRoles(roles);

        // Save to the database
        registerDetailsRepository.save(registerDetails);

        return "Employee added successfully";
    }


    public List<RegisterDetails> getService () {
            return registerDetailsRepository.findAll();
        }


        //Login
        public String authPostLoginService (UserDetailsDto login){
            RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
            if (user != null) {

                if (passwordEncoder.matches(login.getPassword(), user.getPassword())) {  //compare a raw password with an encoded password
                    return "Login Successfully";
                }


            }
            return "Not";
        }

}





