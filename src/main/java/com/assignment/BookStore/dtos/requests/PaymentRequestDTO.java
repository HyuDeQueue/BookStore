package com.assignment.BookStore.dtos.requests;

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
}
