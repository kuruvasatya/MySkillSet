package com.autowire.collection.set;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class Cart {
    @Autowired
    Set<Book> bookList;

    @Override
    public String toString() {
        return "Cart{" +
                "bookList=" + bookList +
                '}';
    }
}
