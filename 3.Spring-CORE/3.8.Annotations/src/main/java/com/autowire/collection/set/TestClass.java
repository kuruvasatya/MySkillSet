package com.autowire.collection.set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("set.xml");
        Cart c = context.getBean("cart", Cart.class);

        System.out.println(c);
    }
}
