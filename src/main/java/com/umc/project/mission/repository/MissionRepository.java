package com.umc.project.mission.repository;

import com.umc.project.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByRestaurantId(Long restaurantId, Pageable pageRequest);
    @Query(value = "select m from Mission m inner join UserMission um on um.mission = m where um.user.id =:userId and um.completeStatus =:status")
    Page<Mission> findAllByUserIdAndStatus(Long userId, String status, Pageable pageRequest);
}
