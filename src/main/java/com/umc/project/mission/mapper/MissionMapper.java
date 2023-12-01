package com.umc.project.mission.mapper;

import com.umc.project.mission.dto.MissionRequestDTO;
import com.umc.project.mission.dto.MissionResponseDTO;
import com.umc.project.mission.entity.Mission;
import com.umc.project.mission.entity.UserMission;

import java.util.UUID;

public class MissionMapper {
    public static UserMission toUserMission(){
        String randomUUID = String.valueOf(UUID.randomUUID());

        return UserMission.builder()
                .completeStatus("N")
                .certificationNumber(randomUUID)
                .reviewWriteStatus("N")
                .build();
    }



    public static MissionResponseDTO.UserMissionCreateDTO toUserMissionCreateDTO(UserMission userMission){
        return MissionResponseDTO.UserMissionCreateDTO.builder()
                .id(userMission.getId())
                .build();
    }
}
