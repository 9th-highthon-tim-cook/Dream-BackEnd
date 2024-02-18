package com.ggoom.dreem.chat;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateChatRequest {
    private String message;
    private Long senderId;
    private Long receiverId;

    public Chat toEntity() {
        return Chat.builder()
                .message(this.message)
                .senderId(this.senderId)
                .receiverId(this.receiverId)
                .build();
    }
}
