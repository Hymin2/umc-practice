package com.umc.project.mission.exception;

import com.umc.project.global.exception.GeneralException;
import com.umc.project.global.payload.code.BaseErrorCode;

public class MissionException extends GeneralException {
    public MissionException(BaseErrorCode code) {
        super(code);
    }
}
