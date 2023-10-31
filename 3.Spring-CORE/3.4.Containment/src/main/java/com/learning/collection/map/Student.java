package com.learning.collection.map;

import java.util.*;
public class Student {
    String name;
    Map<String,Address> address;

    public Student(String name, Map<String,Address> address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
