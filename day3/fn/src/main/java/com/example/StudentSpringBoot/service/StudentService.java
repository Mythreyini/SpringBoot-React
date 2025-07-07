package com.example.StudentSpringBoot.service;


import com.example.StudentSpringBoot.model.StudentModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {


    List<StudentModel> student=new ArrayList<> ( Arrays.asList(new StudentModel(1,"abi","Maths"), new StudentModel(2,"anu","Cpp"))
    );//list of object for model



    public List<StudentModel> getService(){
        return student;
    }


    public StudentModel getServicebyId(int id){
        int ind=0;
        boolean flag=false;
        for(int i=0;i<student.size();i++){
            if(id==student.get(i).getId()){//if user entered id in postman is equal to the id in list
                System.out.println("StudentId: "+student.get(i).getId()+student.get(i));
                ind=i;
                flag=true;

                break;
            }
            else{
                return new StudentModel();//not found that student with that id
            }
        }
        if(flag){
            return student.get(ind);
        }
        return new StudentModel();
    }

    public String postMethodService(StudentModel s){
        student.add(s);
        return "student added";
    }

    public StudentModel putMethodService(int id,StudentModel s){
        int i=0;
        boolean flag = false;
        for(int j=0;j<student.size();j++){
            if(id==student.get(i).getId()){
                i=j;
                flag=true;
                break;
            }
            else{
                return new StudentModel();
            }
        }
        if(flag){

            return student.set(i,s);
        }
        return new StudentModel();
    }




    public StudentModel deleteMethodService(int id) {
       int i=0;
       boolean flag=false;
       for(int j=0;j<student.size();j++){
           if(id==student.get(i).getId()){
               System.out.println(student.get(i));

               i=j;
               flag=true;
               break;
           }
           else{
               flag=false;
           }
       }
       if(flag){
          // student.remove(student.get(i));
           return student.remove(id);
       }
       return new StudentModel();
    }
}
