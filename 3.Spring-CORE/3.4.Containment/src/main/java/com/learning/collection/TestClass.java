package com.learning.collection;

import com.learning.collection.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("collection.xml");

        // test list
        Student studentList = (Student)context.getBean("studentList");
        System.out.println(studentList);

        /**
         * Spring do set comparision based on id, to overide this we need to override equals and hashcode
         */

        Student studentSet = (Student) context.getBean("studentSet");
        System.out.println(studentSet);


    }
}
