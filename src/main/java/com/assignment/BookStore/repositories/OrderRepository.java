package com.assignment.BookStore.repositories;

import com.assignment.BookStore.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
