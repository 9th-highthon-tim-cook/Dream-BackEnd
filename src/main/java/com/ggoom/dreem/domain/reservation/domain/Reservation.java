package com.ggoom.dreem.domain.reservation.domain;

import com.ggoom.dreem.domain.post.domain.Post;
import com.ggoom.dreem.domain.user.domain.User;
import com.ggoom.dreem.global.entity.BaseTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_reservation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Reservation extends BaseTime {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime time;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post reservationPost;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User reservationUser;

    @Builder
    public Reservation(LocalDateTime time, Post reservationPost, User reservationUser) {
        this.time = time;
        this.reservationPost = reservationPost;
        this.reservationUser = reservationUser;
    }
}
