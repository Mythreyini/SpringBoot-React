package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.models.TodoEmployee;
import com.example.springbootfirst.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository toDoRepository;

    public List<Employee> getService() {
        return toDoRepository.findAll();
    }

    public String postservice(Employee e) {
        toDoRepository.save(e);
        return "posted successfully";
    }
}
