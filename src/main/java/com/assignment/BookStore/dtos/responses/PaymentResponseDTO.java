package com.assignment.BookStore.dtos.responses;

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
}
