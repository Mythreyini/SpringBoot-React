package com.example.StudentSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Generates getters, setters, toString, equals, hashCode
@AllArgsConstructor // Generates constructor with all fields
@NoArgsConstructor
public class StudentModel {
    private int id;
    private String name;
    private String course;
}

