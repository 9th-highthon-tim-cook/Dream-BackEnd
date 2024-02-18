package com.ggoom.dreem.chat;

import com.ggoom.dreem.global.entity.BaseTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_chat")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Chat extends BaseTime {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Long senderId;
    private Long receiverId;


    @Builder
    public Chat(String message, Long senderId, Long receiverId) {
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }
}
