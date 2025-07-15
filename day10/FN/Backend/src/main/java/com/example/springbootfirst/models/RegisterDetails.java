package com.example.springbootfirst.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;
import java.util.Set;


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

        @Column(nullable = false,unique = true )
        private String email;

       @Column(unique = true)
        private String password;

        @Column(name="user_name",nullable=false,unique=true)
        private String userName;

        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(
                name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "empId"),
                inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId")
        )
        private Set<Roles> roles;



}

