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
    private String userId;
    private String status;
    private Integer amount;
    private LocalDateTime paymentDate;

    public static PaymentResponseDTO toDto(Payment payment) {
        return new PaymentResponseDTO(
                payment.getId(),
                payment.getOrderId(),
                payment.getTransactionId(),
                payment.getUserId(),
                payment.getStatus(),
                payment.getAmount(),
                payment.getPaymentDate()
        );
    }
}
