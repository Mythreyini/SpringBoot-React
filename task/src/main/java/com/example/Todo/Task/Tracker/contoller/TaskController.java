package com.example.Todo.Task.Tracker.contoller;


import com.example.Todo.Task.Tracker.model.TaskModel;
import com.example.Todo.Task.Tracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService ts;


    @GetMapping("/")
    public List<TaskModel> getController(){
        return ts.getService();
    }

    @GetMapping("/{id}")
public TaskModel getControllerId(@PathVariable int id){
        return ts.getIdService(id);
    }


    @PostMapping("/")
    public String postController(@RequestBody TaskModel t){
        ts.postService(t);
        return "Added post";
    }


    @PutMapping("/{id}")
    public TaskModel putController(@PathVariable int id,@RequestBody TaskModel t){
        return ts.putService(id,t);
    }


    @DeleteMapping("/{id}")
    public int deletecontroller(@PathVariable int id){
        return ts.deleteService(id);
    }
}
