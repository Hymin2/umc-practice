package com.umc.project.temp.controller;

import com.umc.project.global.exception.GeneralException;
import com.umc.project.global.payload.ApiResponse;
import com.umc.project.global.payload.code.status.ErrorStatus;
import com.umc.project.temp.dto.TempResponse;
import com.umc.project.temp.exception.TempException;
import com.umc.project.temp.mapper.TempMapper;
import com.umc.project.temp.service.TempService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TempController {
    private final TempService tempService;

    @GetMapping("/temp/test")
    public ApiResponse<TempResponse.TempDTO> getTest(){
        return ApiResponse.onSuccess(TempMapper.toTempTestDTO());
    }

    /*
    @GetMapping("/temp/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> getExceptionTest(@RequestParam Integer flag){
        tempService.checkFlag(flag);

        return ApiResponse.onSuccess(TempMapper.toTempExceptionDTO(flag));
    }

     */

    @GetMapping("/temp/exception")
    public ApiResponse getExceptionTest(@RequestParam Integer flag){
        try {
            tempService.checkFlag(flag);

            return ApiResponse.onSuccess(TempMapper.toTempExceptionDTO(flag));
        } catch (GeneralException e){
            return ApiResponse.onFailure(ErrorStatus._BAD_REQUEST.getCode(), ErrorStatus._BAD_REQUEST.getMessage(), null);
        }
    }
}
