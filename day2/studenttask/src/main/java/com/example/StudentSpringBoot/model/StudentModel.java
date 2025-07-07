package com.example.StudentSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data // Generates getters, setters, toString, equals, hashCode
@AllArgsConstructor // Generates constructor with all fields
public class StudentModel {
        private int id;
        private String name;
        private String course;
    }


