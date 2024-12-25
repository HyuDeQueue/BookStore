package com.assignment.BookStore.services;

import com.assignment.BookStore.dtos.requests.BookRequestDTO;
import com.assignment.BookStore.dtos.responses.BookResponseDTO;
import org.springframework.data.domain.Page;

public interface BookService {
    BookResponseDTO createBook(BookRequestDTO bookRequestDTO);
    BookResponseDTO getBookById(String Id);
    Page<BookResponseDTO> getAllBooks(int page, int limit);
    BookResponseDTO updateBook(String Id, BookRequestDTO bookRequestDTO);
    void deleteBook(String Id);

}
