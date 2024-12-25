package com.assignment.BookStore.services.impl;

import com.assignment.BookStore.dtos.requests.BookRequestDTO;
import com.assignment.BookStore.dtos.responses.BookResponseDTO;
import com.assignment.BookStore.entities.Book;
import com.assignment.BookStore.repositories.BookRepository;
import com.assignment.BookStore.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO) {
        return BookResponseDTO.toDto(bookRepository.save(bookRequestDTO.toEntity()));
    }

    @Override
    public BookResponseDTO getBookById(String Id) {
        return bookRepository.findById(Id)
                .map(BookResponseDTO::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }

    @Override
    public Page<BookResponseDTO> getAllBooks(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<Book> books = bookRepository.findAll(pageable);
        return books.map(BookResponseDTO::toDto);
    }

    @Override
    public BookResponseDTO updateBook(String Id, BookRequestDTO bookRequestDTO) {
        Book book = bookRepository.findById(Id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        book.setTitle(bookRequestDTO.getTitle());
        book.setAuthor(bookRequestDTO.getAuthor());
        book.setOriginalPrice(bookRequestDTO.getOriginalPrice());
        book.setCurrentPrice(bookRequestDTO.getCurrentPrice());
        book.setStock(bookRequestDTO.getStock());
        book.setDescription(bookRequestDTO.getDescription());
        book.setImageData(bookRequestDTO.getImageData());
        book.setCategory(bookRequestDTO.getCategory());
        book.setUpdatedAt(bookRequestDTO.getUpdatedAt());
        return BookResponseDTO.toDto(bookRepository.save(book));
    }

    @Override
    public void deleteBook(String Id) {
        if(!bookRepository.existsById(Id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        bookRepository.deleteById(Id);
    }
}
