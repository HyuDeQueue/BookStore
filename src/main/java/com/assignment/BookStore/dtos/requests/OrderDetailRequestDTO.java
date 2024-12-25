package com.assignment.BookStore.dtos.requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDetailRequestDTO {
    private String bookId;
    private Integer quantity;
    private Integer price;
    //Currently keep
}
