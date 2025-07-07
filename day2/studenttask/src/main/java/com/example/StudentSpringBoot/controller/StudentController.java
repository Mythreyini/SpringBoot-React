package com.example.StudentSpringBoot.controller;


import com.example.StudentSpringBoot.model.StudentModel;
import com.example.StudentSpringBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    StudentService ss;


    @GetMapping("/")
    public List<StudentModel> getControoler(){
        return ss.getService();
    }



    @PostMapping("/")
    public String postMethod(){
        return ss.postMethodService();
    }



    @PutMapping("/")
    public String putMethod(){
        return ss.putMethodService();
    }


    @DeleteMapping("/")
    public String deleteMethod(){
        return ss.deleteMethodService();
    }

}
