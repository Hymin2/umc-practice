package com.umc.project.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionResponseDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserMissionCreateDTO {
        private Long id;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionCreateDTO {
        private Long id;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RestaurantMissionDTO {
        private String name;
        private String content;
        private Integer point;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MyMissionDTO {
        private Long restaurantId;
        private String restaurantName;
        private String name;
        private String content;
        private Integer point;
    }
}
