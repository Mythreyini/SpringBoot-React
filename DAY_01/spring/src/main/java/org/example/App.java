package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("resources.xml");

        Student s = (Student) context.getBean("st");
        String name = s.getName();

        SpringBoot f = (SpringBoot) context.getBean("fun");
        f.hello(name);

        Course1 c1 = (Course1) context.getBean("course1");
        c1.enrollment(name);

        Course2 c2 = (Course2) context.getBean("course2");
        c2.enrollment(name);

        Course3 c3 = (Course3) context.getBean("course3");
        c3.enrollment(name);

        //System.out.println( "Hello World!" );
    }
}