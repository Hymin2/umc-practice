package com.umc.project.mission.repository;

import com.umc.project.mission.entity.Mission;
import com.umc.project.restaurant.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByRestaurantId(Long restaurantId, PageRequest pageRequest);
}
