package com.umc.project.review.entity;

import com.umc.project.restaurant.entity.Restaurant;
import com.umc.project.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "review_table")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "star_point")
    private Double startPoint;

    @Column(name = "created_time")
    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdTime;

    @Column(name = "updated_time")
    @LastModifiedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedTime;

    @OneToMany(mappedBy = "review")
    private List<ReviewImage> reviewImages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public void setUser(User user){
        this.user = user;
    }

    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }
}
