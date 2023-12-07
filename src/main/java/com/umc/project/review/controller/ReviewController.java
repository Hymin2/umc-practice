package com.umc.project.review.controller;

import com.umc.project.global.page.dto.PageDTO;
import com.umc.project.global.page.validation.annotation.CheckPage;
import com.umc.project.global.payload.ApiResponse;
import com.umc.project.review.dto.ReviewRequestDTO;
import com.umc.project.review.dto.ReviewResponseDTO;
import com.umc.project.review.service.ReviewService;
import com.umc.project.user.validation.annotation.ExistUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/review")
public class ReviewController {
    private final ReviewService reviewService;
    @GetMapping
    public ApiResponse<PageDTO<ReviewResponseDTO.MyReviewDTO>> myReview(@RequestParam @ExistUser Long userId,
                                                                        @CheckPage @PageableDefault(page = 0, size = 10) Pageable page){
        System.out.println(page.getPageSize());
        return ApiResponse.onSuccess(reviewService.myReview(userId, page));
    }

    @PostMapping()
    public ApiResponse<ReviewResponseDTO.ReviewCreateDTO> createReview(@RequestBody @Valid ReviewRequestDTO.ReviewCreateDTO reviewCreateDTO){
        return ApiResponse.onSuccess(reviewService.createReview(reviewCreateDTO));
    }
}
