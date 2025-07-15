package com.example.springbootfirst.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TodoEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String title;
    private String description;
    private List<String> status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
