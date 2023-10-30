package com.learning.lsp.correct;

public class MoterCar extends Car {
    Engine e = new Engine();

    public void start() {
        e.start();
    }

    @Override
    public void printFeatures() {
        System.out.println("I am a petrol car ");
    }
}
