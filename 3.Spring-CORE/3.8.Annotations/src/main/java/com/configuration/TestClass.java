package com.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class TestClass {
    public static void main(String args[]) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Computer computer = context.getBean(Computer.class);

        Arrays.asList(context.getBeanDefinitionNames())
                        .stream().forEach(System.out::println);
        System.out.println(computer);
    }
}
