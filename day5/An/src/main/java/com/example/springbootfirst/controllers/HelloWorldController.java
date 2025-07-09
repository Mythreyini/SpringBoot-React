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


    @GetMapping
    public List<Employee> getEmployees(){
        return hws.getEmployees();
    }


//    @PathVariable - getting the data from the path/url
//    get by employee Id
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return hws.getEmployeeById(id);
    }


    @GetMapping("/job/{job}")
    public List<Employee> getEmployeesByJob(@PathVariable String job){
        return hws.getEmployeeByJob(job);
    }


    @GetMapping("/name/{name}")
    public List<Employee> getEmployeesByName(@PathVariable String name){
        return hws.getEmployeeByName(name);
    }


//    @RequestBody binds HTTP request body content to a Java object.
//    post - adding data
    @PostMapping
    public String addEmployee(@RequestBody Employee emp){
        return hws.addEmployee(emp);
    }


//    put - update data
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee emp){
        return hws.updateEmployee(id,emp);
    }

    @DeleteMapping
    public String deleteEmployees(){
        return hws.deleteEmployees();
    }

//    delete - delete data
    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        return hws.deleteEmployeeById(id);
    }
}