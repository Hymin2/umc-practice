package com.umc.project.global.payload.code;

import com.umc.project.global.payload.code.dto.ErrorReasonDTO;

public interface BaseErrorCode {
    ErrorReasonDTO getReason();
    ErrorReasonDTO getReasonHttpStatus();
}
