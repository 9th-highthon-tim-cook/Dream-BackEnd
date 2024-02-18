package com.ggoom.dreem.domain.post.presenstation.dto.request;

import com.ggoom.dreem.domain.post.domain.Post;
import com.ggoom.dreem.domain.user.domain.Mentor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreatePostRequest {
    private String title;
    private int price;
    private String image;

    public Post toEntity(Mentor mentor) {
        return Post.builder()
                .title(title)
                .price(price)
                .image(image)
                .author(mentor)
                .build();
    }
}
