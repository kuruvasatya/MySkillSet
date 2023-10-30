package com.learning.lsp.violation;

import com.learning.lsp.violation.Car;

/**
 * this class violate the LSP, we can not substitute Electric Car with Car
 */
public class ElectricCar extends Car {
    // electric car doesnt have engine, but its inhering the start method which violates LSP
    @Override
    public void printFeatures() {
        System.out.println("I am a electric car ");
    }

}
