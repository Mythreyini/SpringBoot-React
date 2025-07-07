package com.example.springbootfirst.controllers;


import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloWorldController {
    @Autowired
    HelloWorldService hws;
    @GetMapping("/")
    public String hello(){
        return hws.helloWorldService();
    }

    @PostMapping("/")
    public String postMethod(){
        return hws.postMethodService();
    }

    @PutMapping("/")
    public String putMethod(){
        return hws.putMethodService();
    }

    @DeleteMapping("/")
    public String deleteMethod(){
        return hws.deleteMethodService();
    }
}