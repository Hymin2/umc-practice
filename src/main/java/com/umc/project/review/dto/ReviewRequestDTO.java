package com.umc.project.review.dto;

import com.umc.project.restaurant.validation.annotation.ExistRestaurant;
import com.umc.project.user.validation.annotation.ExistUser;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewRequestDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewCreateDTO{
        @ExistUser
        private Long userId;
        @ExistRestaurant
        private Long restaurantId;
        @NotNull
        private String content;
        @NotNull
        private Double startPoint;
    }
}
