package com.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");

        /**
         * @Autowire
         * 1. searches if there is any unique bean of same Type
         * 2. if there are multiple beans of same type then it searches by name
         */
        Human h = context.getBean("human", Human.class);
        System.out.println(h);
    }
}
