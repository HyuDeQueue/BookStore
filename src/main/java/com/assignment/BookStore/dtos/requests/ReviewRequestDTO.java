package com.assignment.BookStore.dtos.requests;

import com.assignment.BookStore.entities.Review;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReviewRequestDTO {
    private String userId;
    private String bookId;
    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;

    public Review toEntity() {
        Review review = new Review();
        review.setUserId(this.userId);
        review.setBookId(this.bookId);
        review.setRating(this.rating);
        review.setComment(this.comment);
        review.setCreatedAt(this.createdAt);
        return review;
    }
}
