package com.assignment.BookStore.repositories;

import com.assignment.BookStore.models.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
