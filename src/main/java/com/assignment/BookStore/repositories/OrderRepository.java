package com.assignment.BookStore.repositories;

import com.assignment.BookStore.entities.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    Page<Order> findAll(Pageable pageable);
    List<Order> findByUserId(String userId);
}
