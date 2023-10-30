package com.learning.srp.violation;
import java.util.*;

/**
 * this book class does every this, it has the properties of a book, it acts as inventory
 * it does all the utility operations and does invoice too,
 * it clearly violates the SRP
 */
class Book {
    private String name;
    private String author;
    private double price;
    public static List<Book> bookInventory = new ArrayList<>();

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    // utility method
    public static void addBook(Book book) {
        Book.bookInventory.add(book);
    }

    // utility method
    public static void removeBook(Book book) {
        Book.bookInventory.remove(book);
    }

    // utility method
    public static void printBooks() {
        Book.bookInventory.forEach(System.out::println);
    }

    // utility method
    public static boolean isAvailable(Book book) {
        return Book.bookInventory.contains(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        Book a = new Book("Spring", "Alice", 500);
        Book b = new Book("hibernate", "bob", 5000);

        Book.addBook(a);
        Book.addBook(b);

        Book.removeBook(b);
        System.out.println(Book.isAvailable(a) + " " + Book.isAvailable(b));
        Book.printBooks();
    }
}
