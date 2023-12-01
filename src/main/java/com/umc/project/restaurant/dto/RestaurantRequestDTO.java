package com.umc.project.restaurant.dto;

import com.umc.project.user.validation.annotation.ExistAddress;
import com.umc.project.user.validation.annotation.ExistUser;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RestaurantRequestDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RestaurantCreateDTO{
        @NotNull
        @ExistUser
        private Long userId;
        @NotNull
        @ExistAddress
        private Long addressId;
        @NotNull
        private String name;
        @NotNull
        private String detailAddress;
    }
}
