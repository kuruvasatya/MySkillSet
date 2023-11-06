package com.configuration;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer {
    private Software software;
    private Hardware hardware;


    public Computer(Software software, Hardware hardware) {
        this.software = software;
        this.hardware = hardware;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "software=" + software +
                ", hardware=" + hardware +
                '}';
    }
}
