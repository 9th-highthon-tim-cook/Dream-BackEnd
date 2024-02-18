package com.ggoom.dreem.domain.goods.domain;

import com.ggoom.dreem.domain.post.domain.Post;
import com.ggoom.dreem.domain.user.domain.Mentor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "tb_goods")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime time;
    private boolean isSold;

    public void updateIsSold(boolean isSold) {
        this.isSold = isSold;
    }

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public Goods(LocalDateTime time, Mentor mentor, boolean isSold) {
        this.time = time;
        this.mentor = mentor;
        this.isSold = isSold;
    }
}
