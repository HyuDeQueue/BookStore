package com.assignment.BookStore.services.impl;

import com.assignment.BookStore.dtos.requests.BookRequestDTO;
import com.assignment.BookStore.dtos.responses.BookResponseDTO;
import com.assignment.BookStore.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class BookServiceImpl implements BookService {
    @Override
    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO) {
        return null;
    }

    @Override
    public BookResponseDTO getBookById(String Id) {
        return null;
    }

    @Override
    public Page<BookResponseDTO> getAllBooks(int page, int limit) {
        return null;
    }

    @Override
    public BookResponseDTO updateBook(String Id, BookRequestDTO bookRequestDTO) {
        return null;
    }

    @Override
    public void deleteBook(String Id) {

    }
}
