package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.models.TodoEmployee;
import com.example.springbootfirst.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoController {


    @Autowired
    ToDoService toDoService;

    @GetMapping("/to")
    public List<Employee> getController(){
        return toDoService.getService();
    }


    @PostMapping("/to")
    public String postcontroller(@RequestBody Employee e){
        return toDoService.postservice(e);

    }
}
