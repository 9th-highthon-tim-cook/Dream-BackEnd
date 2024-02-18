package com.ggoom.dreem.chat;

import com.ggoom.dreem.chat.repository.ChatRepository;
import com.ggoom.dreem.domain.user.domain.User;
import com.ggoom.dreem.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final UserFacade userFacade;
    private final ChatRepository chatRepository;

    @Transactional
    public void createChat(CreateChatRequest request) {
        System.out.println(request.getMessage());
        chatRepository.save(request.toEntity());
    }

    @Transactional
    public List<ChatResponse> getChat(Long senderId, Long receiverId) {
        List<Chat> chats = chatRepository.findAll();
        return chats.stream()
                .map(this::toResponse)
                .toList();
    }

    public ChatResponse toResponse(Chat chat) {
        User user = userFacade.getCurrentUser(false);
        return ChatResponse.builder()
                .message(chat.getMessage())
                .isMine(chat.getSenderId().equals(user.getId()))
                .time(chat.getCreatedDateTime())
                .build();
    }
}
