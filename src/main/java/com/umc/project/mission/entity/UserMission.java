package com.umc.project.mission.entity;

import com.umc.project.user.entity.Point;
import com.umc.project.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "user_mission_table", indexes = @Index(name = "user_mission_index", columnList = "user_id, complete_status"))
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "complete_status")
    private String completeStatus;

    @Column(name = "certification_number")
    private String certificationNumber;

    @Column(name = "review_write_staus")
    private String reviewWriteStatus;

    @Column(name = "created_time")
    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdTime;

    @Column(name = "deadline_time")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date deadlineTime;

    @OneToOne(mappedBy = "userMission")
    private Point point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void setUser(User user){
        this.user = user;
    }

    public void setMission(Mission mission){
        this.mission = mission;
    }
}
