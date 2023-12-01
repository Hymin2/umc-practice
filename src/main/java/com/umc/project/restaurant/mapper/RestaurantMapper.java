package com.umc.project.restaurant.mapper;

import com.umc.project.restaurant.dto.RestaurantRequestDTO;
import com.umc.project.restaurant.dto.RestaurantResponseDTO;
import com.umc.project.restaurant.entity.Restaurant;

public class RestaurantMapper {
    public static Restaurant toRestaurant(RestaurantRequestDTO.RestaurantCreateDTO restaurantCreateDTO){
        return Restaurant.builder()
                .name(restaurantCreateDTO.getName())
                .detailAddress(restaurantCreateDTO.getDetailAddress())
                .status("N")
                .build();
    }

    public static RestaurantResponseDTO.RestaurantCreateDTO toRestaurantCreateDTO(Restaurant restaurant){
        return RestaurantResponseDTO.RestaurantCreateDTO.builder()
                .id(restaurant.getId())
                .build();
    }
}
