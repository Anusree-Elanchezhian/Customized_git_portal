package com.example.demo.mapper;

import com.example.demo.dto.ReviewDto;
import com.example.demo.entity.Review;

public class ReviewMapper {

    public static ReviewDto mapToReviewDto(Review review) {
        return new ReviewDto(
                review.getId(),
                review.getName(),
                review.getRating(),
                review.getComments()
        );
    }

    public static Review mapToReview(ReviewDto reviewDto) {
        Review review = new Review();
        review.setId(reviewDto.getId());
        review.setName(reviewDto.getName());
        review.setRating(reviewDto.getRating());
        review.setComments(reviewDto.getComments());
        return review;
    }
}
