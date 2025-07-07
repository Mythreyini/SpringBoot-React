package com.example.SpringBotApp.model;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Generates getters, setters, toString, equals, hashCode
@AllArgsConstructor // Generates constructor with all fields
@NoArgsConstructor
public class EmployeeModel {
    private int id;
    private String name;
    private String Job;
}
