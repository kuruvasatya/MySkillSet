package com.learning.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ref.xml");

        Student s = (Student) context.getBean("student2");
        System.out.println(s);
    }
}
