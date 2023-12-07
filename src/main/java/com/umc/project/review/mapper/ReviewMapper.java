package com.umc.project.review.mapper;

import com.umc.project.global.page.dto.PageDTO;
import com.umc.project.review.dto.ReviewRequestDTO;
import com.umc.project.review.dto.ReviewResponseDTO;
import com.umc.project.review.dto.ReviewResponseDTO.MyReviewDTO;
import com.umc.project.review.entity.Review;
import java.util.List;
import org.springframework.data.domain.Page;

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

    public static ReviewResponseDTO.MyReviewDTO toMyReviewDTO(Review review){
        return MyReviewDTO.builder()
                .restaurantName(review.getRestaurant().getName())
                .createdAt(review.getCreatedTime())
                .starPoint(review.getStartPoint())
                .content(review.getContent())
                .build();
    }

    public static PageDTO<ReviewResponseDTO.MyReviewDTO> toMyReviewPageDTO(Page<Review> review){
        List<MyReviewDTO> myReviewDTOs = review
                .stream()
                .map(ReviewMapper::toMyReviewDTO)
                .toList();

        return PageDTO.<ReviewResponseDTO.MyReviewDTO>builder()
                .isLast(review.isLast())
                .isFirst(review.isFirst())
                .totalPage(review.getTotalPages())
                .listSize(review.getSize())
                .totalElements(review.getTotalElements())
                .results(myReviewDTOs)
                .build();
    }
}
