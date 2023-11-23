package com.umc.project.temp.exception;

import com.umc.project.global.exception.GeneralException;
import com.umc.project.global.payload.code.BaseErrorCode;

public class TempException extends GeneralException {
    public TempException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
