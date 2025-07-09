package com.example.springbootfirst.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfiguration {
    // // to convert to pop-up
//    @Bean
//    public PasswordEncoder passwordEncoder(){          //BCryptPasswordEncoder hashes passwords for secure storage.
//        return new BCryptPasswordEncoder();
//    }
    @Bean//This class will define beans (objects managed by Spring).
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.
                csrf((csrf)->csrf.disable()) //lambda functon->disable the csrf to disable sign in form
                .authorizeHttpRequests(auth->auth.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
