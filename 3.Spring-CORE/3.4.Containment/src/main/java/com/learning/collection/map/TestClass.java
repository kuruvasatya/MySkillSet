package com.learning.collection.map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("collection-map.xml");

        // test Map
        Student s = (Student)context.getBean("studentMap");
        System.out.println(s);
    }
}
