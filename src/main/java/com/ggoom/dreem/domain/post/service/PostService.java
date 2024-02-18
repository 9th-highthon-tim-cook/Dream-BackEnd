package com.ggoom.dreem.domain.post.service;

import com.ggoom.dreem.domain.post.domain.Post;
import com.ggoom.dreem.domain.post.domain.repository.PostRepository;
import com.ggoom.dreem.domain.post.presenstation.dto.request.CreatePostRequest;
import com.ggoom.dreem.domain.post.presenstation.dto.response.PostListResponse;
import com.ggoom.dreem.domain.post.presenstation.dto.response.PostResponse;
import com.ggoom.dreem.domain.user.domain.User;
import com.ggoom.dreem.domain.user.domain.repository.UserRepository;
import com.ggoom.dreem.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserFacade userFacade;
    private final UserRepository userRepository;
//    private final PostRepositoryCustom postRepositoryCustom;

    @Transactional
    public void createPost(CreatePostRequest request) {
        User user = userFacade.getCurrentUser(false);
        postRepository.save(request.toEntity(user.getMentorList().get(0)));
    }

    @Transactional
    public PostResponse getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        User user = userRepository.findById(post.getAuthor().getId()).orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));
        return PostResponse.builder()
                .name(user.getNickname())
                .career(user.getMentorList().get(0).getCareer())
                .profileImg(user.getProfileImg())
                .title(post.getTitle())
                .description(post.getDescription())
                .image(post.getImage())
                .price(post.getPrice())
                .time(post.getCreatedDateTime())
                .build();
    }
    @Transactional
    public List<PostListResponse> getPostList(String career, LocalDateTime date, LocalDateTime date2) {
        return postRepository.findAll().stream()
                .map(PostListResponse::of)
                .toList();
    }
}
