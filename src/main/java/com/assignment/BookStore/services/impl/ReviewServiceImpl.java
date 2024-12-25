package com.assignment.BookStore.services.impl;

import com.assignment.BookStore.dtos.requests.ReviewRequestDTO;
import com.assignment.BookStore.dtos.responses.ReviewResponseDTO;
import com.assignment.BookStore.entities.Review;
import com.assignment.BookStore.repositories.ReviewRepository;
import com.assignment.BookStore.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO) {
        return ReviewResponseDTO.toDto(reviewRepository.save(reviewRequestDTO.toEntity()));
    }

    @Override
    public ReviewResponseDTO getReviewById(String Id) {
        return reviewRepository.findById(Id)
                .map(ReviewResponseDTO::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Review not found"));
    }

    @Override
    public Page<ReviewResponseDTO> getAllReviews(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<Review> reviews = reviewRepository.findAll(pageable);
        return reviews.map(ReviewResponseDTO::toDto);
    }

    @Override
    public ReviewResponseDTO updateReview(String Id, ReviewRequestDTO reviewRequestDTO) {
        Review review = reviewRepository.findById(Id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found"));
        review.setBookId(reviewRequestDTO.getBookId());
        review.setUserId(reviewRequestDTO.getUserId());
        review.setRating(reviewRequestDTO.getRating());
        review.setComment(reviewRequestDTO.getComment());
        return ReviewResponseDTO.toDto(reviewRepository.save(review));
    }

    @Override
    public void deleteReview(String Id) {
        if(!reviewRepository.existsById(Id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found");
        }
        reviewRepository.deleteById(Id);
    }
}
