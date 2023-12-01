package com.umc.project.user.validation.validator;

import com.umc.project.user.service.AddressService;
import com.umc.project.user.validation.annotation.ExistAddress;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressExistValidator implements ConstraintValidator<ExistAddress, Long> {
    private final AddressService addressService;
    @Override
    public void initialize(ExistAddress constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = addressService.existsById(value);

        return isValid;
    }
}
