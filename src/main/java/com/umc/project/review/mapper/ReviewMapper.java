package com.umc.project.review.mapper;

import com.umc.project.review.dto.ReviewRequestDTO;
import com.umc.project.review.dto.ReviewResponseDTO;
import com.umc.project.review.entity.Review;

public class ReviewMapper {
    public static Review toReview(ReviewRequestDTO.ReviewCreateDTO reviewCreateDTO){
        return Review.builder()
                .content(reviewCreateDTO.getContent())
                .startPoint(reviewCreateDTO.getStartPoint())
                .build();
    }

    public static ReviewResponseDTO.ReviewCreateDTO toReviewCreateDTO(Review review){
        return ReviewResponseDTO.ReviewCreateDTO.builder()
                .reviewId(review.getId())
                .build();
    }
}
