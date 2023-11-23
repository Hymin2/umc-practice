package com.umc.project.temp.service;

import com.umc.project.global.payload.code.status.ErrorStatus;
import com.umc.project.temp.exception.TempException;

public class TempServiceImpl implements TempService{
    @Override
    public void checkFlag(Integer flag) {
        if(flag == 1) throw new TempException(ErrorStatus._BAD_REQUEST);
    }
}
