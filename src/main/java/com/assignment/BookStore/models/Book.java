package com.assignment.BookStore.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
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

