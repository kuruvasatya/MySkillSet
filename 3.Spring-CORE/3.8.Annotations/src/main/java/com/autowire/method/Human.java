package com.autowire.method;

import org.springframework.beans.factory.annotation.Autowired;

public class Human {
    Heart heart;

    Human() {

    }

    @Autowired
    public void someMehod(Heart heart) {
        System.out.println("I am called automatically");
        this.heart = heart;
    }

    /**
     * The below method when uncommented will fail, as spring tries to inject int value but it cannnot
     * @return
     */

//    @Autowired
//    public void someMehod(Heart heart, int value) {
//        System.out.println("I am called automatically: value " + value);
//        this.heart = heart;
//    }

    @Override
    public String toString() {
        return "Human{" +
                "heart=" + heart +
                '}';
    }
}
