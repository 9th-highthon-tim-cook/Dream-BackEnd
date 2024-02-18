package com.ggoom.dreem.domain.goods.domain.repository;

import com.ggoom.dreem.domain.goods.domain.Goods;
import com.ggoom.dreem.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Goods findByPostAndTime(Post post, LocalDateTime time);
}
