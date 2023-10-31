package com.learning.collection.map;

import java.util.Objects;

public class Address {
    String city;
    int pincode;

    public Address(String city, int pincode) {
        this.city = city;
        this.pincode = pincode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return pincode == address.pincode && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, pincode);
    }

    @Override
    public String
    toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
