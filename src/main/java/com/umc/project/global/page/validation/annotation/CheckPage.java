package com.umc.project.global.page.validation.annotation;

import com.umc.project.global.page.validation.validator.PageValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = PageValidator.class)
@Target( { ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "잘못된 페이지 입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

