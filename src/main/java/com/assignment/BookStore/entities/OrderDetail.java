package com.assignment.BookStore.entities;

import lombok.*;

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

