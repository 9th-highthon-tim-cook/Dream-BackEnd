package com.ggoom.dreem.domain.post.domain;

import com.ggoom.dreem.domain.goods.domain.Goods;
import com.ggoom.dreem.domain.reservation.domain.Reservation;
import com.ggoom.dreem.domain.user.domain.Mentor;
import com.ggoom.dreem.global.entity.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int price;
    private String description;
    @Column(length = 1000)
    private String image;
    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor author;
    @OneToMany(mappedBy = "post")
    private List<Goods> goods;

    @OneToMany(mappedBy = "reservationPost")
    private List<Reservation> reservationList;

    @Builder
    public Post(String title, int price, String image, Mentor author) {
        this.title = title;
        this.price = price;
        this.image = image;
        this.author = author;
    }

}
