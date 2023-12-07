package com.umc.project.mission.service;

import com.umc.project.global.page.dto.PageDTO;
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
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final UserService userService;
    private final RestaurantService restaurantService;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    @Transactional
    public MissionResponseDTO.UserMissionCreateDTO createUserMission(MissionRequestDTO.UserMissionCreateDTO userMissionCreateDTO){
        UserMission userMission = MissionMapper.toUserMission();

        User user = userService.findById(userMissionCreateDTO.getUserId());
        Mission mission = findById(userMissionCreateDTO.getMissionId());

        userMission.setUser(user);
        userMission.setMission(mission);

        userMissionRepository.save(userMission);

        return MissionMapper.toUserMissionCreateDTO(userMission);
    }

    @Transactional
    public MissionResponseDTO.MissionCreateDTO createMission(MissionRequestDTO.MissionCreateDTO missionCreateDTO){
        Mission mission = MissionMapper.toMission(missionCreateDTO);

        Restaurant restaurant = restaurantService.findById(missionCreateDTO.getRestaurantId());
        mission.setRestaurant(restaurant);

        missionRepository.save(mission);

        return MissionMapper.toMissionCreateDTO(mission);
    }

    @Transactional
    public PageDTO<MissionResponseDTO.RestaurantMissionDTO> restaurantMissions(Long restaurantId, Integer page){
        Page<Mission> missionPage = missionRepository.findAllByRestaurantId(restaurantId, PageRequest.of(page, 10));

        return MissionMapper.toRestaurantMissionPageDTO(missionPage);
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
