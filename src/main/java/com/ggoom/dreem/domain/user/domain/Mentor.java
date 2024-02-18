package com.ggoom.dreem.domain.user.domain;

import com.ggoom.dreem.domain.goods.domain.Goods;
import com.ggoom.dreem.domain.post.domain.Post;
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

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_mentor")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int salary;
    private String career;
    private String company;
    private int careerYear;
    private int fame;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "mentor")
    private List<Goods> goodsList = new ArrayList<>();

    @OneToMany(mappedBy = "author")
    private List<Post> postList = new ArrayList<>();

    @Builder
    public Mentor(int salary, String career, String company, int careerYear, String description, User user) {
        this.salary = salary;
        this.career = career;
        this.company = company;
        this.careerYear = careerYear;
        this.user = user;
        this.description = description;
    }

}
