package com.ggoom.dreem.domain.post.domain.repository;

import com.ggoom.dreem.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
