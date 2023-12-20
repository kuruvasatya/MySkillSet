package com.learning.SpringDataJPA.dao;

import com.learning.SpringDataJPA.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
