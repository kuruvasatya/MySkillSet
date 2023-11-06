package com.configuration;

public class Hardware {
    String name;
    String brand;

    public Hardware(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Hardware{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
