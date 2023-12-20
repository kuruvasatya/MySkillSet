package com.learning.SpringDataJPA.service;

import com.learning.SpringDataJPA.dao.AuthorRepo;
import com.learning.SpringDataJPA.dao.BookRepo;
import com.learning.SpringDataJPA.entity.Author;
import com.learning.SpringDataJPA.entity.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AuthorService {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;

    public AuthorService(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @PostConstruct
    private void init() {
        Author author1 = new Author();
        author1.setName("John Doe");

        Author author2 = new Author();
        author2.setName("Jane Smith");

        Author author3 = new Author();
        author3.setName("Bob Johnson");

        Book book1 = new Book();
        book1.setTitle("Introduction to Spring");
        book1.setPublishedYear(2020);
        book1.setPageCount(300);
        book1.setGenre("Technical");
        book1.setAuthor(author1);

        Book book2 = new Book();
        book2.setTitle("Java Programming Basics");
        book2.setPublishedYear(2018);
        book2.setPageCount(250);
        book2.setGenre("Technical");
        book2.setAuthor(author1);

        Book book3 = new Book();
        book3.setTitle("Mystery of the Lost Key");
        book3.setPublishedYear(2019);
        book3.setPageCount(400);
        book3.setGenre("Mystery");
        book3.setAuthor(author2);

        Book book4 = new Book();
        book4.setTitle("Historical Events Unveiled");
        book4.setPublishedYear(2015);
        book4.setPageCount(350);
        book4.setGenre("History");
        book4.setAuthor(author3);

        Book book5 = new Book();
        book5.setTitle("Advanced Data Structures");
        book5.setPublishedYear(2021);
        book5.setPageCount(500);
        book5.setGenre("Technical");
        book5.setAuthor(author3);

        authorRepo.saveAll(Arrays.asList(author1, author2, author3));
        bookRepo.saveAll(Arrays.asList(book1, book2, book3, book4, book5));

    }

    public void testMethod() {
        //list of all authors;
        System.out.println("1.............................");
        List<Author> authorList = authorRepo.findAll();
        authorList.forEach(System.out::println);

        System.out.println("2.............................");
        List<Book> authorNames = authorRepo.findBooksByName("John Doe");
        authorNames.forEach(System.out::println);

        System.out.println("3..............................");
        authorRepo.findAuthorByBooks_Genre("Technical")
                .forEach(System.out::println);

    }
}
