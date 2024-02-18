package com.ggoom.dreem.domain.user.domain;

import com.ggoom.dreem.domain.reservation.domain.Reservation;
import com.ggoom.dreem.domain.user.domain.enums.UserType;
import com.ggoom.dreem.global.entity.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 38)
    private String nickname;

    @Column(unique = true, nullable = false)
    private String userId;
    private String profileImg;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @OneToMany(mappedBy = "user")
    private List<Mentor> mentorList;
    @OneToMany(mappedBy = "reservationUser")
    private List<Reservation> reservationList;

    @Builder
    public User(String nickname, String userId, UserType userType) {
        this.nickname = nickname;
        this.userId = userId;
        this.userType = userType;
    }
}
