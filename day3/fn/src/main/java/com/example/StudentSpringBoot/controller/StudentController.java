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



    //for geeting 1 id
    @GetMapping("/{id}")
    public StudentModel getControolerId(@PathVariable int id){
        return ss.getServicebyId(id);
    }




    @PostMapping("/")
    public String postMethod(@RequestBody StudentModel s){
        //StudentModel student=new StudentModel(5,"varsha","c");
        //return ss.postMethodService(student);

        return ss.postMethodService(s);
    }



    @PutMapping("/{id}")
    public StudentModel putMethod(@PathVariable int id,@RequestBody StudentModel s){
        return ss.putMethodService(id,s);
    }


    @DeleteMapping("/{id}")
    public StudentModel deleteMethod(@PathVariable int id){
        return ss.deleteMethodService(id);
    }

}