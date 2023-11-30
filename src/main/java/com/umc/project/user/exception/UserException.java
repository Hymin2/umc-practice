package com.umc.project.user.exception;

import com.umc.project.global.exception.GeneralException;
import com.umc.project.global.payload.code.BaseErrorCode;

public class UserException extends GeneralException {

    public UserException(BaseErrorCode code) {
        super(code);
    }
}
