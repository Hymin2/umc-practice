package com.umc.project.mission.repository;

import com.umc.project.mission.entity.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    boolean existsByUser_IdAndMission_Id(Long userId, Long missionId);
}
