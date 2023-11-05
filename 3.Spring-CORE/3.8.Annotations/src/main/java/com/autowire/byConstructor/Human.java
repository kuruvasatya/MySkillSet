package com.autowire.byConstructor;

import org.springframework.beans.factory.annotation.Autowired;

public class Human {
    Heart heart;

    Human() {

    }

    @Autowired
    public Human(Heart heart) {
        this.heart = heart;
    }

    @Override
    public String toString() {
        return "Human{" +
                "heart=" + heart +
                '}';
    }
}
