package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeControllerTest {
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;


    @BeforeEach//this refers to before all this will work
    void setup(){
        MockitoAnnotations.openMocks(this);//to mock all test class inside thid
    }

    @Test
    void testRoute(){
String result=employeeController.route();
assertEquals("",result);
    }

    @Test
    void testGetMethod(){
        RegisterDetails emp1=new RegisterDetails();
        RegisterDetails emp2=new RegisterDetails();

        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(emp1,emp2));
        List<RegisterDetails> result=employeeController.getEmployees();
        assertEquals(2,result.size());
    }

}