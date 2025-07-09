package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class demoService {
    @Autowired
    EmployeeRepository empRepo;

    public List<Employee> getEmployee(){
        return empRepo.findAll();
    }

    public Employee getEmployeeById(int id){
//        return empRepo.findById(id).orElse(new Employee());
        return empRepo.getReferenceById(id);
    }

    public String addEmployee(Employee emp){
        empRepo.save(emp);
        return "Employee added successfully";
    }

    public String updateEmployee(Employee emp){
        empRepo.save(emp);
        return "Employee updated successfully";
    }

    public String deleteEmployee(int id){
        empRepo.deleteById(id);
        return "Employee deleted successfully";
    }
}
