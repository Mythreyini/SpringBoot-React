package com.example.SpringBotApp.controller;


import com.example.SpringBotApp.model.EmployeeModel;
import com.example.SpringBotApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {

    @Autowired
    EmployeeService ss;

    @GetMapping("/")
    public List<EmployeeModel> getController(){
        return ss.getService();
    }

    @GetMapping("/job/{job}")
    public List<EmployeeModel> getJobController(@PathVariable String job){
        return ss.getJobService(job);
    }

    @GetMapping("/id/{id}")
    public EmployeeModel getIdController(@PathVariable int id) {
        return ss.getIdService(id);
    }

    @GetMapping("/name/{name}")//http://localhost:8080/name/ram
    public List<EmployeeModel> getNameController(@PathVariable String name) {
        return ss.getNameService(name);
    }

    @PostMapping("/")
    public String postController(@RequestBody EmployeeModel e){
        return ss.postService(e);
    }

    @PutMapping("/{id}")
    public String putController(@RequestBody EmployeeModel e, @PathVariable int id){
        return ss.putService(e, id);
    }

    @DeleteMapping("/id/{id}")
    public String deleteController(@PathVariable int id){
        return ss.deleteService(id);
    }
}
