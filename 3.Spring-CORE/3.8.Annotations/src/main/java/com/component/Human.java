package com.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Human {

    @Autowired
    Heart heart;

    @Override
    public String toString() {
        return "Human{" +
                "heart=" + heart +
                '}';
    }
}
