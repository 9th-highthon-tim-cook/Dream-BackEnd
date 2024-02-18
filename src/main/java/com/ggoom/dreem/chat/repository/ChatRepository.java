package com.ggoom.dreem.chat.repository;

import com.ggoom.dreem.chat.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findAll();
}
