package com.example.Todo.Task.Tracker.service;

import com.example.Todo.Task.Tracker.model.TaskModel;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskService {
    List<TaskModel> ta=new ArrayList<>(Arrays.asList(new TaskModel(1,"Coding","Yet to start")));


    public List<TaskModel> getService(){
        return ta;
    }


    public TaskModel getIdService(int id){
        int i=0;
        boolean f=false;
        for(int j=0;j<ta.size();j++){
            if(id==ta.get(i).getId()){
                f=true;
                i=j;
                break;
            }}
        if(f){
            return ta.get(i);
        }
        return new TaskModel();}

    public String postService(TaskModel t){

        ta.add(t);
        return "Task Added";
    }


    public TaskModel putService(int i,TaskModel t){
        int j=0;
        boolean f=false;
        for(int k=0;k<ta.size();k++){
            if(i==ta.get(k).getId()){
                f=true;
                j=k;
                break;
            }
        }
        if(f){
          return ta.set(j,t);
        }
        return new TaskModel();
    }


    public int deleteService(int i){
        int j=0;
        boolean b=false;
        for(int k=0;k<ta.size();k++){
            if(i==ta.get(k).getId()){
                j=k;
                b=true;
                break;
            }
        }
        if(b){
            ta.remove(j);
            return i;

        }
        return 0;
    }

}



