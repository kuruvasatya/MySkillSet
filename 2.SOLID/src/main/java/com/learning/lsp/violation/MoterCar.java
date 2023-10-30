package com.learning.lsp.violation;

public class MoterCar extends Car {
    Engine e = new Engine();

    @Override
    public void start() {
        e.start();
    }

    @Override
    public void printFeatures() {
        System.out.println("I am a petrol car ");
    }
}
