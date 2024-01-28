package com.learning.HelloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String printHelloWorld() throws InterruptedException {
        Thread.sleep(50000);
        return Thread.currentThread().getName();
    }
}
