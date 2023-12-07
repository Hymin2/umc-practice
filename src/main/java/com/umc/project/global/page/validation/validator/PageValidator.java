package com.umc.project.global.page.validation.validator;

import com.umc.project.global.page.validation.annotation.CheckPage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.data.domain.Pageable;

public class PageValidator implements ConstraintValidator<CheckPage, Pageable> {
    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Pageable value, ConstraintValidatorContext context) {
        final Integer minValue = 1;

        if(value.getPageNumber() < minValue) {
            return false;
        }

        return true;
    }
}
