package com.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("qualifier.xml");

        /**
         * @Autowire
         * 1. searches if there is any unique bean of same Type
         * 2. if there are multiple beans of same type then it searches by name
         */
        Sapien h = context.getBean("sapien", Sapien.class);
        System.out.println(h);
    }
}
