package com.assignment.BookStore.models;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {

    @Id
    private String id;

    private String orderId;
    private String transactionId;
    private String status;
    private String paymentDate;
}

