package com.steve.student_library_system.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter @Setter
public class Book {
    @Getter
    private static List<Book> booksList = new ArrayList<>(List.of(
            new Book("The Hobbit", "J.R.R. Tolkien", "978-0547928227", "Fantasy", 10.99, true),
            new Book("Clean Code", "Robert C. Martin", "978-0132350884", "Programming", 34.95, true),
            new Book("Atomic Habits", "James Clear", "978-0735211292", "Self-help", 16.20, false),
            new Book("1984", "George Orwell", "978-0451524935", "Dystopian", 9.99, true),
            new Book("Sapiens", "Yuval Noah Harari", "978-0062316097", "History", 18.50, false)
    ));

    private String title;
    private String author;
    private String isbn;
    private String category;
    private double price;
    private boolean isAvailable;
}
