package com.umc.project.restaurant.exception;

import com.umc.project.global.exception.GeneralException;
import com.umc.project.global.payload.code.BaseErrorCode;

public class RestaurantException extends GeneralException {
    public RestaurantException(BaseErrorCode code) {
        super(code);
    }
}
