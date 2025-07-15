package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;



//to get username and password from db and use it as custom for auhtnetication
@Service
public class CustomUserDetailsService  implements UserDetailsService {
    @Autowired
    RegisterDetailsRepository registerDetailsRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*3 things
        1.loading data from ur db
        2.setting up the authorities
        3.returning up proper UserDetails
         */


        //step1
        RegisterDetails user=registerDetailsRepository.findByUserName(username)
                .orElseThrow(()->new RuntimeException("User Not Found"));




        //step2
        Set<GrantedAuthority> authorities=user.getRoles().stream()
                .map(roles->new SimpleGrantedAuthority((roles.getRoleName())))
                .collect(Collectors.toSet());

        //step3
        return new User(user.getUserName(),user.getPassword(),authorities);

    }
}
