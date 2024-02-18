package com.ggoom.dreem.chat;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ChatResponse {
    private String message;
    private boolean isMine;
    private LocalDateTime time;
}
