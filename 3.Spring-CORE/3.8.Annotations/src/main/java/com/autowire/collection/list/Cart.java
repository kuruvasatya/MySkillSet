package com.autowire.collection.list;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class Cart {
    @Autowired
    List<Book> bookList;

    @Override
    public String toString() {
        return "Cart{" +
                "bookList=" + bookList +
                '}';
    }
}
