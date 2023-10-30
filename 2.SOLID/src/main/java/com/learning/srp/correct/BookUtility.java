package com.learning.srp.correct;

import java.util.*;

/**
 * Novel Utility has high degree of Cohesion, as each method is doing something similar
 */

public class BookUtility {
    private static List<Book> bookInventory = new ArrayList<>();

    public void addNovel(Book novel) {
        BookUtility.bookInventory.add(novel);
    }

    public void removeNovel(Book novel) {
        BookUtility.bookInventory.remove(novel);
    }

    public boolean isAvailable(Book novel) {
        return BookUtility.bookInventory.contains(novel);
    }

    public void printBooks() {
        BookUtility.bookInventory.forEach(System.out::println);
    }
}
