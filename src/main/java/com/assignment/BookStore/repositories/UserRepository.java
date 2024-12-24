package com.assignment.BookStore.repositories;

import com.assignment.BookStore.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
