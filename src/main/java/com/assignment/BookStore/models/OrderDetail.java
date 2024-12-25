package com.assignment.BookStore.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDetail {
    private String bookId;
    private Integer quantity;
    private Integer price;
}

