package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.EmployeeRepository;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    RegisterDetailsRepository regRepo;

    public List<RegisterDetails> getAllEmployees(){
        return regRepo.findAll();
    }

    public RegisterDetails getEmployeeById(int id){
        return regRepo.findById(id);
    }

    public String addEmployee(RegisterDetails registerDetails){
        regRepo.save(registerDetails);
        return "Employee added successfully";
    }

    public String updateEmployee(int id , RegisterDetails registerDetails){
        regRepo.save(registerDetails);
        return "Employee updated successfully";
    }

    public String deleteEmployeeById(int id){
        regRepo.deleteById(id);
        return "Employee deleted successfully";
    }

    public String deleteEmployees(){
        regRepo.deleteAll();
        return "All employee deleted successfully";
}
}
