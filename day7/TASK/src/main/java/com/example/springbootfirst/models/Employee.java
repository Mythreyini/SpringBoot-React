package com.example.springbootfirst.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id") // <-- this line is key
    private Long empId;

    private String empName;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<TodoEmployee> todos = new ArrayList<>();
}

