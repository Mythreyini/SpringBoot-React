package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {

    @Autowired
    EmployeeRepository empRepo;

    public List<Employee> getEmployees(){
        return empRepo.findAll();
    }

    public Employee getEmployeeById(int id){
        return empRepo.findReferenceById(id); // (or)
//        return empRepo.findById(id).get(); // (or)
//        return empRepo.findById(id); -> then the return type should be Optional<Employee> // (or)
//        return empRepo.findById(id).orElse(new Employee);
    }

    public List<Employee> getEmployeeByJob(String job){
        return empRepo.findByJob(job);
    }

    public List<Employee> getEmployeeByName(String name){
        return empRepo.findByName(name);
    }

    public String addEmployee(Employee emp){
        empRepo.save(emp);
        return "Employee added Successfully";
    }

    public String updateEmployee(int id,Employee emp){
        empRepo.save(emp);
        return "Employee updated successfully";
    }

    public String deleteEmployees(){
        empRepo.deleteAll();
        return "All employee deleted Successfully";
    }

    public String deleteEmployeeById(int id) {
        empRepo.deleteById(id);
        return "Employee details deleted Successfully";
    }
}
