package com.example.springbootfirst.services;


import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    RegisterDetailsRepository registerDetailsRepository;




    //post
    public String addNewService(RegisterDetails register) {
//        RegisterDetails registerDetails=new RegisterDetails();
//        registerDetails.setEmpId(register.getEmpId());
//        registerDetails.setEmail(register.getEmail());
//        registerDetails.setGender(register.getGender());
//        registerDetails.setRole(register.getRole());
//        registerDetails.setDateOfBirth(register.getDateOfBirth());
//        registerDetails.setEmpName(register.getEmpName());
//        registerDetails.setPassword(register.getPassword());
        registerDetailsRepository.save(register);
        return "Employee added successfully";
    }

    public List<RegisterDetails> getService() {
        return registerDetailsRepository.findAll();
    }




    //Login
    public String authPostLoginService(RegisterDetails login){
        RegisterDetails user=registerDetailsRepository.findByEmail(login.getEmail());
        if(user!=null){
            if(user.getPassword().equals(login.getPassword())){
                return "Login Successfully";
            }
        }
        return "Not";
    }
}
