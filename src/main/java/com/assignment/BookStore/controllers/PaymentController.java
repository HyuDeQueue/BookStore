package com.assignment.BookStore.controllers;

import com.assignment.BookStore.dtos.requests.PaymentRequestDTO;
import com.assignment.BookStore.dtos.responses.PaymentResponseDTO;
import com.assignment.BookStore.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/payment")
@CrossOrigin("*")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    private ResponseEntity<PaymentResponseDTO> createPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        return ResponseEntity.ok(paymentService.createPayment(paymentRequestDTO));
    }

    @GetMapping
    private ResponseEntity<Page<PaymentResponseDTO>> getAllPayments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {
        return ResponseEntity.ok(paymentService.getAllPayments(page, limit));
    }

    @GetMapping("/{Id}")
    private ResponseEntity<PaymentResponseDTO> getPaymentById(@PathVariable String Id) {
        return ResponseEntity.ok(paymentService.getPaymentById(Id));
    }

    @PutMapping("/{Id}")
    private ResponseEntity<PaymentResponseDTO> updatePayment(@PathVariable String Id,@RequestBody PaymentRequestDTO paymentRequestDTO) {
        return ResponseEntity.ok(paymentService.updatePayment(Id, paymentRequestDTO));
    }

    @DeleteMapping("/{Id}")
    private void deletePayment(@PathVariable String Id) {
        paymentService.deletePayment(Id);
    }
}
