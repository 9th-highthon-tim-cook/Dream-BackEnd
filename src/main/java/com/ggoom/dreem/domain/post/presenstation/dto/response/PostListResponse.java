package com.ggoom.dreem.domain.post.presenstation.dto.response;

import com.ggoom.dreem.domain.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PostListResponse {
    private Long id;
    private String title;
    private String nickname;
    private LocalDateTime time;
    private int price;
    private String image;

    public static PostListResponse of(Post post) {
        return PostListResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .nickname(post.getAuthor().getUser().getNickname())
                .time(post.getCreatedDateTime())
                .price(post.getPrice())
                .image(post.getImage())
                .build();
    }
}
