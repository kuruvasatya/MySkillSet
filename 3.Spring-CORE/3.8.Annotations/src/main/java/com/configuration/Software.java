package com.configuration;

public class Software {
    String name;
    String version;

    public Software(String name, String version) {
        this.name = name;
        this.version = version;
    }

    @Override
    public String toString() {
        return "Software{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
