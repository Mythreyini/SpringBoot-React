package com.example.springbootfirst.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getters, setters, toString, equals, hashCode
@AllArgsConstructor // Generates constructor with all fields
@NoArgsConstructor // Generates constructor with no filed
@Entity
public class Employee {
    @Id // primary key
//    @GeneratedValue(strategy = GenerationType.IDENTITY) - if you give this you should not give this field in input this will be auto generated
    private int id;
    private String name;
    private String job;
}
