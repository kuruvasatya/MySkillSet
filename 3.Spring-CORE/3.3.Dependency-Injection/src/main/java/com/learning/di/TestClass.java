package com.learning.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static  void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("di.xml");

        Student s = (Student) context.getBean("student");
        System.out.println(s);
    }
}
