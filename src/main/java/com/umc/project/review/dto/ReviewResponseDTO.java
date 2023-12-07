package com.umc.project.review.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewResponseDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewCreateDTO{
        private Long reviewId;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MyReviewDTO{
        private String restaurantName;
        private Double starPoint;
        private String content;
        private Date createdAt;
    }
}
