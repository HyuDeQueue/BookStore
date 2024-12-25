package com.assignment.BookStore.dtos.requests;

import com.assignment.BookStore.entities.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO {
    private String orderId;
    private String transactionId;
    private String status;
    private String paymentDate;

    public Payment toEntity() {
        Payment payment = new Payment();
        payment.setOrderId(this.orderId);
        payment.setTransactionId(this.transactionId);
        payment.setStatus(this.status);
        payment.setPaymentDate(this.paymentDate);
        return payment;
    }
}
