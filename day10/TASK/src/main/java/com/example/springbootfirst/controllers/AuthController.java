package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping
    public List<RegisterDetails> getRegisterDetails(){
        return authService.getRegisterDetails();
    }

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserDetailsDto register) {
        return authService.addNewUser(register);
    }

    @PostMapping("/login")
    public String login(@RequestBody RegisterDetails login) {
        return authService.loginUser(login);
    }

}


