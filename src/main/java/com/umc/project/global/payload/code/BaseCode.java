package com.umc.project.global.payload.code;

import com.umc.project.global.payload.code.dto.ReasonDTO;

public interface BaseCode {
    ReasonDTO getReason();
    ReasonDTO getReasonHttpStatus();
}
