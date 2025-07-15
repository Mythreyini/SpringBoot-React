package com.example.springbootfirst.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator=new Calculator();
    @Test
    public void addTest(){
        assertEquals(3,calculator.addTest(1,2));
     }


    @Test
    public void subTest(){
        assertEquals(5,calculator.subTest(10,3));
    }


    @Test
    public void mulTest(){
        assertEquals(3,calculator.multiplicationTest(1,3));
    }

    @Test
    public void divTest(){
        assertEquals(3,calculator.divisionTest(1,3));
    }




}
