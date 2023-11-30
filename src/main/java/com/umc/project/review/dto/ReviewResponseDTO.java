package com.umc.project.review.dto;

import com.umc.project.user.validation.annotation.ExistUser;
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
}
