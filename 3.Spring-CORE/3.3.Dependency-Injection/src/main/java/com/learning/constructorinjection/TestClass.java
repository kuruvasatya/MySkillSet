package com.learning.constructorinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static  void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("constructor.xml");

        Student s = (Student) context.getBean("student02");
        System.out.println(s);
    }
}
