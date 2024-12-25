package com.assignment.BookStore.dtos.requests;

import com.assignment.BookStore.entities.Payment;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentRequestDTO {
    private String orderId;
    private String transactionId;
    private String status;
    private LocalDateTime paymentDate;

    public Payment toEntity() {
        Payment payment = new Payment();
        payment.setOrderId(this.orderId);
        payment.setTransactionId(this.transactionId);
        payment.setStatus(this.status);
        payment.setPaymentDate(this.paymentDate);
        return payment;
    }
}
