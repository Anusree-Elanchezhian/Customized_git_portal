package com.example.demo.service;

import com.example.demo.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(ReviewDto reviewDto);

    ReviewDto getReviewById(Long reviewId);

    List<ReviewDto> getAllReviews();

    ReviewDto updateReview(Long reviewId, ReviewDto reviewDto);

    void deleteReview(Long reviewId);
}
