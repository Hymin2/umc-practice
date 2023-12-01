package com.umc.project.mission.validation.validator;

import com.umc.project.mission.dto.MissionRequestDTO;
import com.umc.project.mission.service.MissionService;
import com.umc.project.mission.validation.annotation.NotExistUserMission;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMissionNotExistValidator implements ConstraintValidator<NotExistUserMission, MissionRequestDTO.UserMissionCreateDTO> {
    private final MissionService missionService;
    @Override
    public void initialize(NotExistUserMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionRequestDTO.UserMissionCreateDTO value, ConstraintValidatorContext context) {
        boolean isValid = missionService.existsByUserIdAndMissionId(value.getUserId(), value.getMissionId());

        return isValid;
    }
}
