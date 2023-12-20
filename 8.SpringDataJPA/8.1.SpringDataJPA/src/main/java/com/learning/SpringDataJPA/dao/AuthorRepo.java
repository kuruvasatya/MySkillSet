package com.learning.SpringDataJPA.dao;

import com.learning.SpringDataJPA.entity.Author;
import com.learning.SpringDataJPA.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;
import java.util.stream.Stream;

public interface AuthorRepo extends JpaRepository<Author, Integer > {
    // 1. find all author with details
    List<Author> findAll();

    // 2. print all books by given author
    @Query("select a.books from AuthorEntity a where a.name = :name")
    List<Book> findBooksByName(@Param("name") String name);

    //3. find all authors with given genre
    List<Author> findAuthorByBooks_Genre(String genre);
}
