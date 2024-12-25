package com.assignment.BookStore.repositories;

import com.assignment.BookStore.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
