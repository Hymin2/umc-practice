package com.umc.project.restaurant.service;

import com.umc.project.global.payload.code.status.ErrorStatus;
import com.umc.project.restaurant.entity.Restaurant;
import com.umc.project.restaurant.exception.RestaurantException;
import com.umc.project.restaurant.repository.RestaurantRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Restaurant findById(Long id){
        return restaurantRepository.findById(id).orElseThrow(() -> new RestaurantException(ErrorStatus.RESTAURANT_NOT_FOUND));
    }

    public boolean existsById(Long id) {
        return restaurantRepository.existsById(id);
    }
}
