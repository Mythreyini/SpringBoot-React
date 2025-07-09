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



    @GetMapping("/name/{name}")
    public List<StudentModel> getNameController(@PathVariable String name){
        return ss.getNameService(name);
    }

    @GetMapping("/course/{course}")
public List<StudentModel> getCourseController(@PathVariable String course){
        return ss.getCourseService(course);
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
    public String deleteIdMethod(@PathVariable int id){
        return ss.deleteIdMethodService(id);
    }


    @DeleteMapping("/")
    public String deleteAllMethod(){
        return ss.deleteAllMethodService();
    }


}