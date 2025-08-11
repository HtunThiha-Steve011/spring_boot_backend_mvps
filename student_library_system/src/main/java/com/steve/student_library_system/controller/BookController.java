package com.steve.student_library_system.controller;

import com.steve.student_library_system.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @PostMapping("/create")
    public ResponseEntity createNewBook(@RequestBody Book book) {
        Book.getBooksList().add(book);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(Book.getBooksList());
    }

    @GetMapping("/{bookIndex}")
    public ResponseEntity<Book> getBookByIndex(@RequestParam Integer bookIndex) {
        return ResponseEntity.ok(Book.getBooksList().get(bookIndex));
    }
}
