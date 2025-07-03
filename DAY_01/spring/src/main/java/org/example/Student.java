package org.example;

import java.util.Scanner;

public class Student {
    public Student(){
        System.out.println("Application started");
    }

    public String getName(){
        Scanner scn = new Scanner(System.in);
        System.out.println("to enroll in all the courses");
        System.out.println("Enter your name : ");
        String name = scn.next();
        System.out.println();
        return name;
    }
}