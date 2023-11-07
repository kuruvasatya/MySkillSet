package com.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan(basePackages = {"com.component"})
public class TestClass {
    public static void main(String args[]) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestClass.class);
        Human h = context.getBean(Human.class);
        System.out.println(h);
    }
}
