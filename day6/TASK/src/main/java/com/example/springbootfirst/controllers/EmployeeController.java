package com.example.springbootfirst.controllers;


import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {

    @Autowired
    EmployeeService hws;


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public List<Employee> getEmployees(){
        return hws.getEmployees();
    }


//    @PathVariable - getting the data from the path/url
//    get by employee Id
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return hws.getEmployeeById(id);
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/job/{job}")
    public List<Employee> getEmployeesByJob(@PathVariable String job){
        return hws.getEmployeeByJob(job);
    }




    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/name/{name}")
    public List<Employee> getEmployeesByName(@PathVariable String name){
        return hws.getEmployeeByName(name);
    }


//    @RequestBody binds HTTP request body content to a Java object.
//    post - adding data
@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public String addEmployee(@RequestBody Employee emp){
        return hws.addEmployee(emp);
    }


//    put - update data
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee emp){
        return hws.updateEmployee(id,emp);
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
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