package com.example.SpringBotApp.repository;

import com.example.SpringBotApp.model.EmployeeModel;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel,Integer> {
    EmployeeModel findReferenceById(int id);
}


//You're creating a Spring Data JPA repository for the EmployeeModel entity.
//This code defines a Repository Interface in Spring Boot that helps in performing CRUD operations
// (Create, Read, Update, Delete) on
//the database without writing SQL queries manually.
//https://chatgpt.com/share/686b55d8-4814-8002-ae25-54e7bd988537
//Parameter	Meaning
//EmployeeModel	This is the Entity class. It represents a table in the database.