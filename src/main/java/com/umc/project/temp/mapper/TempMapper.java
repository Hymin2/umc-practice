package com.umc.project.temp.mapper;

import com.umc.project.temp.dto.TempResponse;

public class TempMapper {
    public static TempResponse.TempDTO toTempTestDTO(){
        return TempResponse.TempDTO.builder()
                .string("This is Test!")
                .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
