package com.learning.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClassByName {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autowire.xml");

        Student s = (Student) context.getBean("student1");
        System.out.println(s);
    }
}
