package com.umc.project.mission.dto;

import com.umc.project.mission.validation.annotation.ExistMission;
import com.umc.project.mission.validation.annotation.NotExistUserMission;
import com.umc.project.restaurant.validation.annotation.ExistRestaurant;
import com.umc.project.user.validation.annotation.ExistUser;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionRequestDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @NotExistUserMission
    public static class UserMissionCreateDTO {
        @ExistUser
        private Long userId;
        @ExistMission
        private Long missionId;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionCreateDTO {
        @ExistRestaurant
        private Long restaurantId;
        @NotNull
        private String name;
        @NotNull
        private String content;
        @NotNull
        private Integer point;
    }
}
