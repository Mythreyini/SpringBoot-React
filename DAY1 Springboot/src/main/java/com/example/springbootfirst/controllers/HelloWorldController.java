package com.example.springbootfirst.controllers;


import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class HelloWorldController {
    @Autowired
    HelloWorldService hws;

    @GetMapping("/")
    public List<Employee> getMethod(){
        return hws.getMethodService();
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