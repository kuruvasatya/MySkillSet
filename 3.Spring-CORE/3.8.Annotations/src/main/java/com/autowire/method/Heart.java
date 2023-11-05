package com.autowire.method;


public class Heart {
    String noOfHearts;
    String color;

    public Heart(String noOfHearts, String color) {
        this.noOfHearts = noOfHearts;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Heart{" +
                "noOfHearts='" + noOfHearts + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
