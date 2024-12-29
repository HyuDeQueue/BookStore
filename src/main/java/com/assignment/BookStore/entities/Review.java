package com.assignment.BookStore.entities;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

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
    private Integer rating;
    private String comment;
    private LocalDateTime createdAt = LocalDateTime.now();
}

