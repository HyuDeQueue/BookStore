package com.assignment.BookStore.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {
    private String id;

    private String title;
    private String author;
    private Integer originalPrice;
    private Integer currentPrice;
    private Integer stock;
    private String description;
    private Byte[] imageData;
    private String category;
    private String createdAt;
    private String updatedAt;
}
