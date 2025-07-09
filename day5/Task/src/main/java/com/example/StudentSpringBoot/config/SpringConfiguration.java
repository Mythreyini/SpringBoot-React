package com.example.StudentSpringBoot.config;



//if not encode the password it cannot be acced as here admin cannot be access the dta but Rhythan user can access the data
//on access using admin it display unauthoried user in postman
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfiguration {
    // // to convert to pop-up
    @Bean
    public PasswordEncoder passwordEncoder(){          //BCryptPasswordEncoder hashes passwords for secure storage.
        return new BCryptPasswordEncoder();
    }


    @Bean//This class will define beans (objects managed by Spring).
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.
                csrf((csrf)->csrf.disable()) //lambda functon->disable the csrf to disable sign in form
                .authorizeHttpRequests(auth->auth.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }



    //to create/built a users->need to build username,passworrd and role
    @Bean
    InMemoryUserDetailsManager userDetails(){
        UserDetails admin= User.builder()//user1
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        UserDetails Rhythan= User.builder()//user2
                .username("Rhythan")
                .password(passwordEncoder().encode("Rhythan"))//encoding the password using above  passwordEncoder()
                .roles("USER")
                .build();
        //return admin;
        return new InMemoryUserDetailsManager(admin,Rhythan);

    }

}
