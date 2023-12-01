package com.umc.project.mission.service;

import com.umc.project.global.payload.code.status.ErrorStatus;
import com.umc.project.mission.dto.MissionRequestDTO;
import com.umc.project.mission.dto.MissionResponseDTO;
import com.umc.project.mission.entity.Mission;
import com.umc.project.mission.entity.UserMission;
import com.umc.project.mission.exception.MissionException;
import com.umc.project.mission.mapper.MissionMapper;
import com.umc.project.mission.repository.MissionRepository;
import com.umc.project.mission.repository.UserMissionRepository;
import com.umc.project.restaurant.entity.Restaurant;
import com.umc.project.restaurant.service.RestaurantService;
import com.umc.project.user.entity.User;
import com.umc.project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final UserService userService;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    public MissionResponseDTO.UserMissionCreateDTO createUserMission(MissionRequestDTO.UserMissionCreateDTO userMissionCreateDTO){
        UserMission userMission = MissionMapper.toUserMission();

        User user = userService.findById(userMissionCreateDTO.getUserId());
        Mission mission = findById(userMissionCreateDTO.getMissionId());

        userMission.setUser(user);
        userMission.setMission(mission);

        return MissionMapper.toUserMissionCreateDTO(userMission);
    }

    public Mission findById(Long id){
        return missionRepository.findById(id).orElseThrow(() -> new MissionException(ErrorStatus.MISSION_NOT_FOUND));
    }
    public boolean existsByUserIdAndMissionId(Long userId, Long missionId){
        return userMissionRepository.existsByUser_IdAndMission_Id(userId, missionId);
    }

    public boolean existsById(Long id) {
        return  missionRepository.existsById(id);
    }
}
