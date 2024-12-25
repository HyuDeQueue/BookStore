package com.assignment.BookStore.entities;
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
    private Integer totalPrice;
    private String status;
    private String createdAt;
    private String updatedAt;

    private List<OrderDetail> orderDetails;

}

