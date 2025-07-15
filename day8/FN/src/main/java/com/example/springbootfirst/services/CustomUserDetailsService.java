package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@EnableMethodSecurity
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        /*
        3 things
        1. Loading data from your database
        2. setting up the authorities
        3. returning up proper UserDetails
         */

        // Step 1: Load user
        RegisterDetails user=registerDetailsRepository.findByUserName(username)
                .orElseThrow(()->new RuntimeException("User Not Found"));


        // Step 2: Map roles to authorities (optional: add "ROLE_" prefix)
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName()))
                .collect(Collectors.toSet());

        System.out.println("username : " + username + ", password : " + user.getPassword() + ", authorities : " + authorities);


//        step 3
        return new User(user.getUserName(),user.getPassword(),authorities);
    }
}