package com.ldg.webchat.chat.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

/**
 * 채팅방 DTO
 */
@Getter
@Setter
public class ChatRoomDTO {
    private String roomId; //방 번호
    private String name; //방 제목
    private Set<WebSocketSession> sessions = new HashSet<>();
    private String userId;
    private Boolean isSave;
}
