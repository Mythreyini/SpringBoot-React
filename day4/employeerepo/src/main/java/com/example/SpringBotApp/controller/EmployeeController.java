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


    @GetMapping("/{id}")
    public EmployeeModel getIdController(@PathVariable int id){
        return ss.getIdService(id);
    }

    @PostMapping("/")
    public String postContrllor(@RequestBody EmployeeModel e){
        return ss.postService(e);
    }


    @PutMapping("/{id}")
    public String putContorller(@RequestBody EmployeeModel e,@PathVariable int id){
        return ss.putService( e,id);
    }


    @DeleteMapping("/id")
    public  String deleteContoller(@PathVariable int id){
        return ss.deleteService(id);
    }

}
