package com.assignment.BookStore.services.impl;

import com.assignment.BookStore.dtos.requests.PaymentRequestDTO;
import com.assignment.BookStore.dtos.responses.PaymentResponseDTO;
import com.assignment.BookStore.entities.Payment;
import com.assignment.BookStore.repositories.PaymentRepository;
import com.assignment.BookStore.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public PaymentResponseDTO createPayment(PaymentRequestDTO paymentRequestDTO) {
        return PaymentResponseDTO.toDto(paymentRepository.save(paymentRequestDTO.toEntity()));
    }

    @Override
    public PaymentResponseDTO getPaymentById(String Id) {
        return paymentRepository.findById(Id)
                .map(PaymentResponseDTO::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Payment not found"));
    }

    @Override
    public Page<PaymentResponseDTO> getAllPayments(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<Payment> payments = paymentRepository.findAll(pageable);
        return payments.map(PaymentResponseDTO::toDto);
    }

    @Override
    public PaymentResponseDTO updatePayment(String Id, PaymentRequestDTO paymentRequestDTO) {
        Payment payment = paymentRepository.findById(Id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment not found"));
        payment.setOrderId(paymentRequestDTO.getOrderId());
        payment.setTransactionId(paymentRequestDTO.getTransactionId());
        payment.setStatus(paymentRequestDTO.getStatus());
        payment.setPaymentDate(paymentRequestDTO.getPaymentDate());
        return PaymentResponseDTO.toDto(paymentRepository.save(payment));
    }

    @Override
    public void deletePayment(String Id) {
        if(!paymentRepository.existsById(Id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment not found");
        }
        paymentRepository.deleteById(Id);
    }
}
