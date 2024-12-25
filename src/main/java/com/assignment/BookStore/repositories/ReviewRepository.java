package com.assignment.BookStore.repositories;

import com.assignment.BookStore.entities.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
