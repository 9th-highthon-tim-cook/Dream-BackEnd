package com.ggoom.dreem.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping("")
    public void createChat(@RequestBody CreateChatRequest request) {
        chatService.createChat(request);
    }

    @GetMapping("")
    public List<ChatResponse> getChat(Long senderId, Long receiverId) {
        return chatService.getChat(senderId, receiverId);
    }

}
