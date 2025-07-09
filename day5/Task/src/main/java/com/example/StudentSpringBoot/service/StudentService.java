package com.example.StudentSpringBoot.service;


import com.example.StudentSpringBoot.Repository.StudentRepository;
import com.example.StudentSpringBoot.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

@Autowired
   StudentRepository sr;


    public List<StudentModel> getService(){
        return sr.findAll();
    }


    public StudentModel getServicebyId(int id){

        return sr.getReferenceById(id);
    }


    public  List<StudentModel> getNameService(String s){
        return sr.findByName(s);
    }



    public List<StudentModel> getCourseService(String s){
        return sr.findByCourse(s);
    }


    public String postMethodService(StudentModel s){
        sr.save(s);
        return "student added";
    }

    public StudentModel putMethodService(int id,StudentModel s){

        return sr.save(s);
    }




    public String deleteIdMethodService(int id) {

      sr.deleteById(id);
      return "Deleted";
    }

    public String deleteAllMethodService(){
        sr.deleteAll();
        return "Deleted All";
    }
}
