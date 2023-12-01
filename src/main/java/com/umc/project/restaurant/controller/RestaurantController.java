package com.umc.project.restaurant.controller;

import com.umc.project.global.payload.ApiResponse;
import com.umc.project.restaurant.dto.RestaurantRequestDTO;
import com.umc.project.restaurant.dto.RestaurantResponseDTO;
import com.umc.project.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping
    public ApiResponse<RestaurantResponseDTO.RestaurantCreateDTO> createRestaurant(RestaurantRequestDTO.RestaurantCreateDTO restaurantCreateDTO){
        return ApiResponse.onSuccess(restaurantService.createRestaurant(restaurantCreateDTO));
    }
}
