package com.assignment.BookStore.entities;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

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
    private String userId;
    private Integer amount;
    private String status;
    private LocalDateTime paymentDate = LocalDateTime.now();
}

