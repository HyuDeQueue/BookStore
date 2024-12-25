package com.assignment.BookStore.repositories;

import com.assignment.BookStore.entities.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {

    Page<Payment> findAll(Pageable pageable);
}
