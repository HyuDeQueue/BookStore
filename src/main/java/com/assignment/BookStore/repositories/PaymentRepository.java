package com.assignment.BookStore.repositories;

import com.assignment.BookStore.models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
