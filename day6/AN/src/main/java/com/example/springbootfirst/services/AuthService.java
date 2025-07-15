package com.example.springbootfirst.services;


import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    RegisterDetailsRepository registerDetailsRepository;


    @Autowired
    PasswordEncoder passwordEncoder;


    //post
    public String addNewService(RegisterDetails register) {
        RegisterDetails registerDetails=new RegisterDetails();
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setGender(register.getGender());
        registerDetails.setRole(register.getRole());
        registerDetails.setDateOfBirth(register.getDateOfBirth());
        registerDetails.setEmpName(register.getEmpName());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));//to encode the password//while using encoded password it will login but on actual password not login  //this bcrpty follows sort256 alogrithm so that it changes the password at each run
        registerDetailsRepository.save(registerDetails);//to save to db  //$2a$ → BCrypt version
        return "Employee added successfully";
    }

    public List<RegisterDetails> getService() {
        return registerDetailsRepository.findAll();
    }




    //Login
    public String authPostLoginService(RegisterDetails login){
        RegisterDetails user=registerDetailsRepository.findByEmail(login.getEmail());
        if(user!=null){
            //if(user.getPassword().equals(login.getPassword())){
            if(passwordEncoder.matches(login.getPassword(), user.getPassword())){  //compare a raw password with an encoded password
                return "Login Successfully";
            }

            //login.getPassword() is the raw password entered by user
            //
            //user.getPassword() is the encoded password from the database
        }
        return "Not";
    }
}





//this is used to take unquie email only so that while login with same email it wont give the 500 eroor
//
//@Column(unique = true)
//private String email;

