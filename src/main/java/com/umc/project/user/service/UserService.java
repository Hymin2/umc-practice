package com.umc.project.user.service;

import com.umc.project.global.payload.code.status.ErrorStatus;
import com.umc.project.user.entity.User;
import com.umc.project.user.exception.UserException;
import com.umc.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserException(ErrorStatus.USER_NOT_FOUND));
    }

    public boolean existsById(Long id){
        return userRepository.existsById(id);
    }
}
