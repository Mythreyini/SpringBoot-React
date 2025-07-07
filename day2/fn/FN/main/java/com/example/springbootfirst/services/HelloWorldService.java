package com.example.springbootfirst.services;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public String helloWorldService(){
        return "Hello";
    }

    //post
    public String postMethodService(){
        return "This is post method";
    }

    public String putMethodService(){
        return "This is put method";
    }

    public String deleteMethodService() {
        return "This is delete method";
    }
}
