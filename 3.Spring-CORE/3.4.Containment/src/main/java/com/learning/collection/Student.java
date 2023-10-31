package com.learning.collection;
import java.util.*;
public class Student {
    String name;
    List<Address> address;

    public Student(String name, List<Address> address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String
    toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
