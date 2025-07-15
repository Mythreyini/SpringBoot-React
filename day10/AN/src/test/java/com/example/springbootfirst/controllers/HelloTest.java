package com.example.springbootfirst.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {
    @Test
    public void testHelloTest(){

       Hello hello=new Hello();
       String s=hello.helloTest();
        System.out.println(s);
        assertEquals("This i Test",s);
     }

}
