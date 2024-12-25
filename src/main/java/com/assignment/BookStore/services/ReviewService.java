package com.assignment.BookStore.services;

import com.assignment.BookStore.dtos.requests.ReviewRequestDTO;
import com.assignment.BookStore.dtos.responses.ReviewResponseDTO;
import org.springframework.data.domain.Page;

public interface ReviewService {
    ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO);

    ReviewResponseDTO getReviewById(String Id);

    Page<ReviewResponseDTO> getAllReviews(int page, int limit);

    ReviewResponseDTO updateReview(String Id, ReviewRequestDTO reviewRequestDTO);
    void deleteReview(String Id);
}