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
    @Table(name = "Register_employee")
    public class UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "emp_name")
        private String name;

        @Column(name = "email",unique = true)
        private String email;

        @Column(name = "password_emp",unique = true)
        int password;

        String gender;
        Date DateOfBirth;
        String roles;
    }

