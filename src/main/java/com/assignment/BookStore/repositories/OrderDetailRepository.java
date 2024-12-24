package com.assignment.BookStore.repositories;

import com.assignment.BookStore.models.OrderDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderDetailRepository extends MongoRepository<OrderDetail, String> {
}
