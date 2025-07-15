package com.example.springbootfirst.config;
//https://chatgpt.com/share/686df3ce-43b8-8002-a154-5d794eed5559
//if not encode the password it cannot be acced as here admin cannot be access the dta but Rhythan user can access the data
//on access using admin it display unauthoried user in postman
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SpringConfiguration {
    // // to convert to pop-up
    @Bean
    public PasswordEncoder passwordEncoder(){          //BCryptPasswordEncoder hashes passwords for secure storage.
        return new BCryptPasswordEncoder();
    }




    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                csrf((csrf)->csrf.disable())
                .authorizeHttpRequests(auth->{
//                    auth.requestMatchers(HttpMethod.POST,"/").hasRole("ADMIN");//"/" FOR THIS ROUTE ALOINE PROVIDE ACCESS TO ADMIN TO POST
//                    auth.requestMatchers(HttpMethod.GET,"/").hasRole("ADMIN");//Only users with ROLE_ADMIN can access GET METHOD/.
//                    auth.requestMatchers(HttpMethod.PUT,"/{id}").hasRole("USER");//only role:USER with usernmae:Rhuthan can able to put who can acces or use only rout {id} or  http://localhost:3001/1
//                    auth.requestMatchers(HttpMethod.GET,"/name/{name}").hasRole("USER");
//                    auth.requestMatchers(HttpMethod.DELETE,"/{id}").hasAnyRole("USER","ADMIN");
//                    auth.requestMatchers(HttpMethod.GET,"/**").hasRole("USER");//to access any url or path by Rhythan of GET Method
                     auth.anyRequest().authenticated();     //Every incoming HTTP request must be logged in (i.e., the user must be authenticated).   with permissions
                })
               // .formLogin(Customizer.withDefaults());
        .httpBasic(Customizer.withDefaults());         //=> pop-up

        return http.build();
    }






    //ROLE BASED AUTHENTICATion
    //to create/built a users->need to build username,passworrd and role
    @Bean
    InMemoryUserDetailsManager userDetails(){//  https://chatgpt.com/share/686de9f4-40c0-8002-afac-b550a3f2f37d    store in RAM
        UserDetails admin= User.builder()//user1
                .username("admin")
                .password(passwordEncoder().encode("admin"))//passord must be include with noop/encode
                .roles("ADMIN")//this roles was provided inside app.prop
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
