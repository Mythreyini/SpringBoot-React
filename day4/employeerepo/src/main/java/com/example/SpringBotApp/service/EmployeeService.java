package com.example.SpringBotApp.service;


import com.example.SpringBotApp.model.EmployeeModel;
import com.example.SpringBotApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

@Autowired
EmployeeRepository er;
public List<EmployeeModel> getService(){
        return er.findAll() ;
    }



    public EmployeeModel getIdService(int id){

        return er.findReferenceById(id);
    }


    public  String postService(EmployeeModel e){
 er.save(e);
 return "Added Employee";
    }

    public String putService(EmployeeModel e,int id){
    er.save(e);
        return "Employee updated successfully";

    }


public String deleteService(int id){

    er.deleteById(id);
return "deleted";

}}
