package com.assignment.BookStore.dtos.responses;

import com.assignment.BookStore.entities.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDTO {
    private String id;

    private String orderId;
    private String transactionId;
    private String status;
    private String paymentDate;

    public static PaymentResponseDTO toDto(Payment payment) {
        return new PaymentResponseDTO(
                payment.getId(),
                payment.getOrderId(),
                payment.getTransactionId(),
                payment.getStatus(),
                payment.getPaymentDate()
        );
    }
}
