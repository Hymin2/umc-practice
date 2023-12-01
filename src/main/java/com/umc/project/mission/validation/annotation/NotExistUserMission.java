package com.umc.project.mission.validation.annotation;

import com.umc.project.mission.validation.validator.UserMissionNotExistValidator;
import com.umc.project.restaurant.validation.validator.RestaurantExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;



@Documented
@Constraint(validatedBy = UserMissionNotExistValidator.class)
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotExistUserMission {
    String message() default "이미 수락한 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
