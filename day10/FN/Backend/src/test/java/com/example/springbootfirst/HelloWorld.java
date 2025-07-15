package com.example.springbootfirst;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class HelloWorld {

    @GetMapping("/")
    public String hello(){
        System.out.println("hello world");
        return "Hello folks, Welcome to SpringBoot Rollercoaster";
    }
}
