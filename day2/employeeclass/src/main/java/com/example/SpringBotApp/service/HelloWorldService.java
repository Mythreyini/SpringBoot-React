package com.example.SpringBotApp.service;


import com.example.SpringBotApp.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;


import java.util.List;

@Service
public class HelloWorldService {

    List<Employee> emp = new ArrayList<>(
            Arrays.asList(new Employee(1,"abi","Trainer"), new Employee(2,"anu","Faculty"))
    );

    public List<Employee> getMethodService(){
        return emp;
    }

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