package com.ggoom.dreem.domain.post.presenstation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostResponse {
    private Long id;
    private String name;
    private String career;
    private String profileImg;
    private String title;
    private String description;
    private String image;
    private int price;
    private LocalDateTime time;
}
