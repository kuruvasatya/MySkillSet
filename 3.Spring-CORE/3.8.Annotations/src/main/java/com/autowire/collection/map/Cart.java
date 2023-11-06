package com.autowire.collection.map;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class Cart {
    @Autowired
    Map<String, Book> bookList;

    @Override
    public String toString() {
        return "Cart{" +
                "bookList=" + bookList +
                '}';
    }
}
