package com.assignment.BookStore.repositories;

import com.assignment.BookStore.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
