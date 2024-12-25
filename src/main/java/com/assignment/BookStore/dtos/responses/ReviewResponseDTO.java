package com.assignment.BookStore.dtos.responses;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReviewResponseDTO {
    private String id;

    private String userId;
    private String bookId;
    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;

    public static ReviewResponseDTO toDto(com.assignment.BookStore.entities.Review review) {
        return new ReviewResponseDTO(
                review.getId(),
                review.getUserId(),
                review.getBookId(),
                review.getRating(),
                review.getComment(),
                review.getCreatedAt()
        );
    }
}
