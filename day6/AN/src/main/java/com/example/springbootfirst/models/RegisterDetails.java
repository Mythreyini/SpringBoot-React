package com.example.springbootfirst.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;




    @Data
    @AllArgsConstructor // Generates constructor with all fields
    @NoArgsConstructor // Generates constructor with no filed
    @Entity
    @Table(name = "user_details")
    public class RegisterDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int empId;

        @Column(name = "emp_name" ,nullable=false)//to get mandatory
        private String empName;

        @Column(unique = true)
        private String email;

       // @Column(name = "password_emp",unique = true)
        private String password;

        private String gender;
        @Column(name = "date_of_birth")
        private Date dateOfBirth;
        private String role;
    }

