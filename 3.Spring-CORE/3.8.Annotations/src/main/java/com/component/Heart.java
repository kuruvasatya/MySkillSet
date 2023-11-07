package com.component;

import org.springframework.stereotype.Component;

@Component
public class Heart {
    int noOfHearts = 2;
    String color = "Red";

    @Override
    public String toString() {
        return "Heart{" +
                "noOfHearts=" + noOfHearts +
                ", color='" + color + '\'' +
                '}';
    }
}
