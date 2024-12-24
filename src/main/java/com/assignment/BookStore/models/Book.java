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
    private double price;
    private int stock;
    private String description;
    private String imageUrl;
    private String category;
    private String createdAt;
    private String updatedAt;
}

