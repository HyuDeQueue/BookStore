package com.assignment.BookStore.controllers;

import com.assignment.BookStore.dtos.requests.ReviewRequestDTO;
import com.assignment.BookStore.dtos.responses.ReviewResponseDTO;
import com.assignment.BookStore.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/review")
@CrossOrigin("*")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    private ResponseEntity<ReviewResponseDTO> createReview(@RequestBody ReviewRequestDTO reviewRequestDTO) {
        return ResponseEntity.ok(reviewService.createReview(reviewRequestDTO));
    }
    @GetMapping
    private ResponseEntity<Page<ReviewResponseDTO>> getAllReviews(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {
        return ResponseEntity.ok(reviewService.getAllReviews(page, limit));
    }

    @GetMapping("/{Id}")
    private ResponseEntity<ReviewResponseDTO> getReviewById(@PathVariable String Id) {
        return ResponseEntity.ok(reviewService.getReviewById(Id));
    }

    @PutMapping("/{Id}")
    private ResponseEntity<ReviewResponseDTO> updateReview(@PathVariable String Id,@RequestBody ReviewRequestDTO reviewRequestDTO) {
        return ResponseEntity.ok(reviewService.updateReview(Id, reviewRequestDTO));
    }

    @DeleteMapping("/{Id}")
    private void deleteReview(@PathVariable String Id) {
        reviewService.deleteReview(Id);
    }

    @GetMapping("/book/{bookId}")
    private ResponseEntity<Page<ReviewResponseDTO>> getReviewsByBookId(@PathVariable String bookId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(reviewService.getReviewsByBookId(bookId, page, limit));
    }
}
