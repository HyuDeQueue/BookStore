package com.assignment.BookStore.dtos.responses;

import com.assignment.BookStore.entities.Payment;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentResponseDTO {
    private String id;

    private String orderId;
    private String transactionId;
    private String status;
    private LocalDateTime paymentDate;

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
