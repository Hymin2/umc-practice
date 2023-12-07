package com.umc.project.global.page.validation.validator;

import com.umc.project.global.page.validation.annotation.CheckPage;
import com.umc.project.global.payload.code.status.ErrorStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PageValidator implements ConstraintValidator<CheckPage, Integer> {
    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        Integer minValue = 1;

        if(value < minValue) {
            return false;
        }

        return true;
    }
}
