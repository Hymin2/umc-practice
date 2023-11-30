package com.umc.project.review.controller;

import com.umc.project.global.payload.ApiResponse;
import com.umc.project.review.dto.ReviewRequestDTO;
import com.umc.project.review.dto.ReviewResponseDTO;
import com.umc.project.review.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping()
    public ApiResponse<ReviewResponseDTO.ReviewCreateDTO> createReview(@RequestBody @Valid ReviewRequestDTO.ReviewCreateDTO reviewCreateDTO){
        return ApiResponse.onSuccess(reviewService.createReview(reviewCreateDTO));
    }
}
