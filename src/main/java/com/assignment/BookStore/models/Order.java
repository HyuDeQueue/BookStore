package com.assignment.BookStore.models;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    private String id;

    private String userId;
    private double totalPrice;
    private String status;  // (Pending, Completed, Canceled)
    private String createdAt;
    private String updatedAt;

    private List<OrderDetail> orderDetails;  // Embedding OrderDetails

}

