package com.ldg.webchat.api.service;

import com.ldg.webchat.api.entity.Chat;
import com.ldg.webchat.api.repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service("APIService")
public class APIService {
    private final ChatRepository chatRepository;

    public APIService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public void insertMessage(String message, String userId, String roomId) {
        Chat chat = new Chat();

        chat.setMessage(message);
        chat.setRoomId(roomId);
        chat.setRegistrationId(userId);
        chat.setRegistrationDatetime(LocalDateTime.now());

        chatRepository.save(chat);
    }

    public List<Chat> selectMessage(String roomId) {
        return chatRepository.findByRoomId(roomId);
    }
}
