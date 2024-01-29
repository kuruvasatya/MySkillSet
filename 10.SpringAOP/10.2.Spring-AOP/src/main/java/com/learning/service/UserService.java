package com.learning.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void getData() {
        System.out.println("Getting the data");
    }

    public String getUserName() {
        return "Satya";
    }

    public void throwException() {
        throw new RuntimeException("Exception occured");
    }


}
