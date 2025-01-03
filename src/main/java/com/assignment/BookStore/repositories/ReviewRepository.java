package com.assignment.BookStore.repositories;

import com.assignment.BookStore.entities.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
    Page<Review> findAll(Pageable pageable);

    Page<Review> findByBookId(String bookId, Pageable pageable);
}
