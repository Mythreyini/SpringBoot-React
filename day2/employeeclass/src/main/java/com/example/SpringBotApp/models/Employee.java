package com.example.SpringBotApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Generates getters, setters, toString, equals, hashCode
@AllArgsConstructor // Generates constructor with all fields
public class Employee {
    private int id;
    private String name;
    private String job;
}
