package com.assignment.BookStore.models;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Review {

    @Id
    private String id;

    private String userId;
    private String bookId;
    private int rating;  // (1-5 stars)
    private String comment;
    private String createdAt;
}

