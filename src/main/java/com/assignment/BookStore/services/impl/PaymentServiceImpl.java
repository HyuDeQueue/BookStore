package com.assignment.BookStore.services.impl;

import com.assignment.BookStore.dtos.requests.PaymentRequestDTO;
import com.assignment.BookStore.dtos.responses.PaymentResponseDTO;
import com.assignment.BookStore.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    @Override
    public PaymentResponseDTO createPayment(PaymentRequestDTO paymentRequestDTO) {
        return null;
    }

    @Override
    public PaymentResponseDTO getPaymentById(String Id) {
        return null;
    }

    @Override
    public Page<PaymentResponseDTO> getAllPayments(int page, int limit) {
        return null;
    }

    @Override
    public PaymentResponseDTO updatePayment(String Id, PaymentRequestDTO paymentRequestDTO) {
        return null;
    }

    @Override
    public void deletePayment(String Id) {

    }
}
