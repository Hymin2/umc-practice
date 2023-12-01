package com.umc.project.restaurant.service;

import com.umc.project.global.payload.code.status.ErrorStatus;
import com.umc.project.restaurant.dto.RestaurantRequestDTO;
import com.umc.project.restaurant.dto.RestaurantResponseDTO;
import com.umc.project.restaurant.entity.Restaurant;
import com.umc.project.restaurant.exception.RestaurantException;
import com.umc.project.restaurant.mapper.RestaurantMapper;
import com.umc.project.restaurant.repository.RestaurantRepository;
import java.util.Optional;

import com.umc.project.user.entity.Address;
import com.umc.project.user.entity.User;
import com.umc.project.user.service.AddressService;
import com.umc.project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final UserService userService;
    private final AddressService addressService;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public RestaurantResponseDTO.RestaurantCreateDTO createRestaurant(RestaurantRequestDTO.RestaurantCreateDTO restaurantCreateDTO){
        Restaurant restaurant = RestaurantMapper.toRestaurant(restaurantCreateDTO);

        User user = userService.findById(restaurantCreateDTO.getUserId());
        Address address = addressService.findById(restaurantCreateDTO.getAddressId());

        restaurant.setUser(user);
        restaurant.setAddress(address);

        return RestaurantMapper.toRestaurantCreateDTO(restaurant);
    }

    public Restaurant findById(Long id){
        return restaurantRepository.findById(id).orElseThrow(() -> new RestaurantException(ErrorStatus.RESTAURANT_NOT_FOUND));
    }

    public boolean existsById(Long id) {
        return restaurantRepository.existsById(id);
    }
}
