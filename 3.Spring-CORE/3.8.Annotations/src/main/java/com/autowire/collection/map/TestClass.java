package com.autowire.collection.map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("map.xml");
        Cart c = context.getBean("cart", Cart.class);

        System.out.println(c);
    }
}
