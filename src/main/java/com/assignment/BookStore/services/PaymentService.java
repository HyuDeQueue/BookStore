package com.assignment.BookStore.services;

import com.assignment.BookStore.dtos.requests.PaymentRequestDTO;
import com.assignment.BookStore.dtos.responses.PaymentResponseDTO;
import org.springframework.data.domain.Page;

public interface PaymentService {
    PaymentResponseDTO createPayment(PaymentRequestDTO paymentRequestDTO);
    PaymentResponseDTO getPaymentById(String Id);
    Page<PaymentResponseDTO> getAllPayments(int page, int limit);
    PaymentResponseDTO updatePayment(String Id, PaymentRequestDTO paymentRequestDTO);
    void deletePayment(String Id);
}
