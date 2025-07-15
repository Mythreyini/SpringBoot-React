package com.example.springbootfirst.repository;

import com.example.springbootfirst.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ToDoRepository extends JpaRepository<Employee,Integer> {
}
