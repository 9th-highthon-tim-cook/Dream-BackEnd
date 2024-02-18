package com.ggoom.dreem.domain.post.presenstation;

import com.ggoom.dreem.domain.post.presenstation.dto.request.CreatePostRequest;
import com.ggoom.dreem.domain.post.presenstation.dto.response.PostListResponse;
import com.ggoom.dreem.domain.post.presenstation.dto.response.PostResponse;
import com.ggoom.dreem.domain.post.service.PostService;
import com.ggoom.dreem.global.infra.S3.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final AwsS3Service awsS3Service;

    @PostMapping()
    public void createPost(@RequestBody CreatePostRequest request) {
        postService.createPost(request);
    }

    @PostMapping("/image")
    public String uploadImage(@RequestPart("image") MultipartFile image) {
        return awsS3Service.uploadFile(image);
    }

    @GetMapping("/{id}")
    public PostResponse getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @GetMapping("/list")
    public List<PostListResponse> getPostList(
            @RequestParam(value = "career", required = false) String career,
            @RequestParam(value = "date", required = false) LocalDateTime date,
            @RequestParam(value = "date2", required = false) LocalDateTime date2) {
        return postService.getPostList(career, date, date2);

    }
}
