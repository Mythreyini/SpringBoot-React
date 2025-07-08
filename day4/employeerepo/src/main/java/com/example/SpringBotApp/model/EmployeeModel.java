package com.example.SpringBotApp.model;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Generates getters, setters, toString, equals, hashCode
@AllArgsConstructor // Generates constructor with all fields
@NoArgsConstructor
@Entity
public class EmployeeModel {
    @Id


    private int id;
    private String name;
    private String job;

}
