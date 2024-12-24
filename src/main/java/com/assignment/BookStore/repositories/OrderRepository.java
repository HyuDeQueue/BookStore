package com.assignment.BookStore.repositories;

import com.assignment.BookStore.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
