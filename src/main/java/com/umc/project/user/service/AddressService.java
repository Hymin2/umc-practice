package com.umc.project.user.service;

import com.umc.project.global.payload.code.status.ErrorStatus;
import com.umc.project.user.entity.Address;
import com.umc.project.user.exception.UserException;
import com.umc.project.user.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public Address findById(Long id){
        return addressRepository.findById(id).orElseThrow(() -> new UserException(ErrorStatus.ADDRESS_NOT_FOUND));
    }

    public boolean existsById(Long id){
        return addressRepository.existsById(id);
    }
}
