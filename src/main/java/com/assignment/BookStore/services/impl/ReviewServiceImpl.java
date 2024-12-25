package com.assignment.BookStore.services.impl;

import com.assignment.BookStore.dtos.requests.ReviewRequestDTO;
import com.assignment.BookStore.dtos.responses.ReviewResponseDTO;
import com.assignment.BookStore.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    @Override
    public ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO) {
        return null;
    }

    @Override
    public ReviewResponseDTO getReviewById(String Id) {
        return null;
    }

    @Override
    public Page<ReviewResponseDTO> getAllReviews(int page, int limit) {
        return null;
    }

    @Override
    public ReviewResponseDTO updateReview(String Id, ReviewRequestDTO reviewRequestDTO) {
        return null;
    }

    @Override
    public void deleteReview(String Id) {

    }
}
