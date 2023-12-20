package com.learning.SpringDataJPA.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "book_table")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int publishedYear;
    private int pageCount;
    private String genre;
    @ManyToOne
    private Author author;

    public Book(String title, int publishedYear, int pageCount, String genre) {
        this.title = title;
        this.publishedYear = publishedYear;
        this.pageCount = pageCount;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishedYear=" + publishedYear +
                ", pageCount=" + pageCount +
                ", genre=" + genre +
                ", author=" + author.getName() +
                '}';
    }
}
