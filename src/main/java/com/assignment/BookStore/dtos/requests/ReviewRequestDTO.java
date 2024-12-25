package com.assignment.BookStore.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequestDTO {
    private String id;

    private String userId;
    private String bookId;
    private Integer rating;
    private String comment;
    private String createdAt;
}
