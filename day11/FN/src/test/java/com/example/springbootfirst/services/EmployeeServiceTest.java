package com.example.springbootfirst.services;



import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class EmployeeServiceTest {
    @Mock//not authentic or real,
    RegisterDetailsRepository registerDetailsRepository;

    @InjectMocks
    EmployeeService employeeService;

    @BeforeEach
   void setUp(){
       MockitoAnnotations.openMocks(this);
   }


  @Test
   void testGetMethod(){
       RegisterDetails empl1=new RegisterDetails();
       RegisterDetails empl2=new RegisterDetails();

      when(registerDetailsRepository.findAll()).thenReturn(Arrays.asList(empl1,empl2));//when is present inside mokito//this line do (when we call for registerDetailsRepository.findAll() by usinggetAllEmployeeees in service then return the empl1 and empl2 as list
       List<RegisterDetails> result=employeeService.getAllEmployees();//if we findall the employee then return the above empl1,empl2 as list
      System.out.println(result);
       assertEquals(2,result.size());//as result has 2 list empl1 and empl2
//      assertEquals(3,result.size());   //test fails
   }
}



/*Let's break down the code and explain it clearly:

What's happening in the code?

This is a unit test for a service class called EmployeeService. The test class is EmployeeServiceTest.

What's being tested?

The testGetMethod method is testing the getAllEmployees method of the EmployeeService class. This method is supposed to return a list of all employees.

How's the test written?

The test uses Mockito to mock the RegisterDetailsRepository interface, which is a dependency of the EmployeeService class. Mockito allows us to control the behavior of the mock object.

Here's what's happening in the test:

1. We create two RegisterDetails objects (empl1 and empl2).
2. We use Mockito's when method to specify what should happen when the findAll method of the RegisterDetailsRepository interface is called. In this case, we want it to return a list containing empl1 and empl2.
3. We call the getAllEmployees method of the EmployeeService class and store the result in the result variable.
4. We assert that the size of the result list is 3 using assertEquals.

What's the issue?

The problem is that we're expecting the size of the result list to be 3, but we've only added 2 objects to the list in the when method. This means the test will fail because the actual size of the result list will be 2, not 3.

How to fix the issue?

To fix the issue, we can either:

- Change the assertion to expect a size of 2: assertEquals(2, result.size());
- Add another RegisterDetails object to the list in the when method: when(registerDetailsRepository.findAll()).thenReturn(Arrays.asList(empl1, empl2, new RegisterDetails()));

By fixing the issue, we can ensure that the test is accurate and will pass when the getAllEmployees method is working correctly.

In summary:

- The test is testing the getAllEmployees method of the EmployeeService class.
- The test uses Mockito to mock the RegisterDetailsRepository interface.
- The test creates two RegisterDetails objects and specifies what should happen when the findAll method is called.
- The test calls the getAllEmployees method and asserts that the size of the result list is 3 (which is incorrect).
- To fix the issue, we can either change the assertion or add another object to the list in the when method.*/