package com.example.demo.service.impl;

import com.example.demo.dto.ReviewDto;
import com.example.demo.entity.Review;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.ReviewMapper;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        Review review = ReviewMapper.mapToReview(reviewDto);
        Review savedReview = reviewRepository.save(review);
        return ReviewMapper.mapToReviewDto(savedReview);
    }

    @Override
    public ReviewDto getReviewById(Long reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));
        return ReviewMapper.mapToReviewDto(review);
    }

    @Override
    public List<ReviewDto> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(ReviewMapper::mapToReviewDto).collect(Collectors.toList());
    }

    @Override
    public ReviewDto updateReview(Long reviewId, ReviewDto reviewDto) {
        Review existingReview = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));
        Review updatedReview = ReviewMapper.mapToReview(reviewDto);
        updatedReview.setId(existingReview.getId());
        Review savedReview = reviewRepository.save(updatedReview);
        return ReviewMapper.mapToReviewDto(savedReview);
    }

    @Override
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
