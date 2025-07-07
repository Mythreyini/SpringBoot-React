package com.example.SpringBotApp.service;


import com.example.SpringBotApp.model.EmployeeModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    List<EmployeeModel> employee= new ArrayList<> ( Arrays.asList(new EmployeeModel(1,"Ram","Traineer")));


    public List<EmployeeModel> getService(){
        return employee ;
    }



    public EmployeeModel getIdService(int id){
        int i=0;
        boolean flag=false;

        for(int j=0;j<employee.size();j++){
            if(id==employee.get(i).getId()){
                flag=true;
                i=j;
                break;
            }
            else {
                return new EmployeeModel();
            }
        }

        if(flag){
            return employee.get(id);
        }
        return new EmployeeModel();
    }


    public  String postService(EmployeeModel e){
 employee.add(e);
 return "Added Employee";
    }

    public EmployeeModel putService(EmployeeModel e,int id){
       boolean flag=false;
        int i=0;

        for(int j=0;j<employee.size();j++){
            if(id==employee.get(i).getId()){
                flag=true;
                i=j;
                break;
            }
            else{
                return new EmployeeModel();
            }

        }

        if(flag){
            return employee.set(i,e);
        }
        return new EmployeeModel();
    }


public EmployeeModel deleteService(int id){
        int i=0;
        boolean f=false;

        for(int j=0;j<employee.size();j++){
            if(id==employee.get(i).getId()){
                f=true;
                i=j;
                break;
            }
            else{
                return new EmployeeModel();
            }
        }
if(f){
    return employee.remove(id);
}
return new EmployeeModel();

    }


}
