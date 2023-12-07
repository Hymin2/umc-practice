package com.umc.project.review.service;

import com.umc.project.global.page.dto.PageDTO;
import com.umc.project.restaurant.entity.Restaurant;
import com.umc.project.restaurant.service.RestaurantService;
import com.umc.project.review.dto.ReviewRequestDTO;
import com.umc.project.review.dto.ReviewResponseDTO;
import com.umc.project.review.dto.ReviewResponseDTO.MyReviewDTO;
import com.umc.project.review.entity.Review;
import com.umc.project.review.mapper.ReviewMapper;
import com.umc.project.review.repository.ReviewRepository;
import com.umc.project.user.entity.User;
import com.umc.project.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final RestaurantService restaurantService;

    @Transactional
    public ReviewResponseDTO.ReviewCreateDTO createReview(ReviewRequestDTO.ReviewCreateDTO reviewCreateDTO){
        Review review = ReviewMapper.toReview(reviewCreateDTO);
        User user = userService.findById(reviewCreateDTO.getUserId());
        Restaurant restaurant = restaurantService.findById(reviewCreateDTO.getRestaurantId());

        review.setUser(user);
        review.setRestaurant(restaurant);

        reviewRepository.save(review);

        return ReviewMapper.toReviewCreateDTO(review);
    }

    public PageDTO<MyReviewDTO> myReview(Long userId, Integer page){
        Page<Review> review = reviewRepository.findAllByUserId(userId, PageRequest.of(page, 10));

        return ReviewMapper.toMyReviewPageDTO(review);
    }
}
