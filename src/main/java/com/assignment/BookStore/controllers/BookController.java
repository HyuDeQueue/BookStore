package com.assignment.BookStore.controllers;

import com.assignment.BookStore.dtos.requests.BookRequestDTO;
import com.assignment.BookStore.dtos.responses.BookResponseDTO;
import com.assignment.BookStore.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/book")
@CrossOrigin("*")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    private ResponseEntity<BookResponseDTO> addBook(@RequestBody BookRequestDTO bookRequestDto) {
        return ResponseEntity.ok(bookService.createBook(bookRequestDto));
    }

    @GetMapping("/{Id}")
    private ResponseEntity<BookResponseDTO> getBookById(@PathVariable String Id) {
        return ResponseEntity.ok(bookService.getBookById(Id));
    }

    @GetMapping
    private ResponseEntity<Page<BookResponseDTO>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {
        return ResponseEntity.ok(bookService.getAllBooks(page, limit));
    }

    @PutMapping("/{Id}")
    private ResponseEntity<BookResponseDTO> updateBook(@PathVariable String Id,@RequestBody BookRequestDTO bookRequestDto) {
        return ResponseEntity.ok(bookService.updateBook(Id, bookRequestDto));
    }

    @DeleteMapping("/{Id}")
    private void deleteBook(@PathVariable String Id) {
        bookService.deleteBook(Id);
    }
}
