package com.umc.project.mission.controller;

import com.umc.project.global.page.CustomPageRequest;
import com.umc.project.global.page.dto.PageDTO;
import com.umc.project.global.page.validation.annotation.CheckPage;
import com.umc.project.global.payload.ApiResponse;
import com.umc.project.mission.dto.MissionRequestDTO;
import com.umc.project.mission.dto.MissionResponseDTO;
import com.umc.project.mission.service.MissionService;
import com.umc.project.restaurant.validation.annotation.ExistRestaurant;
import com.umc.project.user.validation.annotation.ExistUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mission")
public class MissionController {
    private final MissionService missionService;

    @PostMapping("/user")
    public ApiResponse<MissionResponseDTO.UserMissionCreateDTO> createUserMission(@RequestBody @Valid MissionRequestDTO.UserMissionCreateDTO userMissionCreateDTO){
        return ApiResponse.onSuccess(missionService.createUserMission(userMissionCreateDTO));
    }

    @PostMapping("/restaurant")
    public ApiResponse<MissionResponseDTO.MissionCreateDTO> createMission(@RequestBody @Valid MissionRequestDTO.MissionCreateDTO missionCreateDTO){
        return ApiResponse.onSuccess(missionService.createMission(missionCreateDTO));
    }

    @GetMapping("/user")
    public ApiResponse<PageDTO<MissionResponseDTO.MyMissionDTO>> getMyMissions(@RequestParam @ExistUser Long userId,
                                                                            @RequestParam String status,
                                                                            @CheckPage @PageableDefault(page = 0, size = 10) Pageable page){
        return ApiResponse.onSuccess(missionService.getMyMissions(userId, status, CustomPageRequest.of(page)));
    }

    @GetMapping("/restaurant")
    public ApiResponse<PageDTO<MissionResponseDTO.RestaurantMissionDTO>> getRestaurantMissions(@RequestParam @ExistRestaurant Long restaurantId,
                                                                                            @CheckPage @PageableDefault(page = 0, size = 10) Pageable page){
        return ApiResponse.onSuccess(missionService.getRestaurantMissions(restaurantId, CustomPageRequest.of(page)));
    }
}
