package com.assignment.BookStore.dtos.responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDetailResponseDTO {
    private String bookId;
    private Integer quantity;
    private Integer price;
    //keeping it, not in use
}
