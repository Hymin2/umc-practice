package com.umc.project.restaurant.validation.validator;

import com.umc.project.global.payload.code.status.ErrorStatus;
import com.umc.project.restaurant.service.RestaurantService;
import com.umc.project.restaurant.validation.annotation.ExistRestaurant;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantExistValidator implements ConstraintValidator<ExistRestaurant, Long> {
    private final RestaurantService restaurantService;

    @Override
    public void initialize(ExistRestaurant constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = restaurantService.existsById(value);

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
