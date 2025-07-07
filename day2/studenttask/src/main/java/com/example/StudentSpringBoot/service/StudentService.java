package com.example.StudentSpringBoot.service;


import com.example.StudentSpringBoot.model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {


        List<StudentModel> stu=new ArrayList<> ( Arrays.asList(new StudentModel(1,"abi","Maths"), new StudentModel(2,"anu","Cpp"))
    );



        public List<StudentModel> getService(){
            return stu;
        }

    public String postMethodService(){
        return "This is post method";
    }

    public String putMethodService(){
        return "This is put method";
    }

    public String deleteMethodService() {
        return "This is delete method";
    }
}

