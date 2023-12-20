package com.learning.SpringDataJPA.controller;

import com.learning.SpringDataJPA.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private AuthorService authorService;

    public BookController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/author")
    public void test() {
        authorService.testMethod();
    }
}
