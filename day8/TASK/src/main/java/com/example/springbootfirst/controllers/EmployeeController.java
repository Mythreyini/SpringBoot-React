package com.example.springbootfirst.controllers;


import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {

    @Autowired
    EmployeeService hws;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/")
    public List<RegisterDetails> getEmployees(){
        return hws.getAllEmployees();
    }


//    @PathVariable - getting the data from the path/url
//    get by employee Id
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/id/{id}")
    public RegisterDetails getEmployeeById(@PathVariable int id){
        return hws.getEmployeeById(id);
    }


//    post - adding data
@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public String addEmployee(@RequestBody RegisterDetails emp){
        return hws.addEmployee(emp);
    }


//    put - update data
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody RegisterDetails emp){
        return hws.updateEmployee(id,emp);
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @DeleteMapping
    public String deleteEmployees(){
        return hws.deleteEmployees();
    }

//    delete - delete data
@PreAuthorize("hasAnyRole('ADMIN','USER')")
    @DeleteMapping("/id/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        return hws.deleteEmployeeById(id);
    }
}