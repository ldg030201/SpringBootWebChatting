package com.ldg.webchat.chat.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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

    /**
     * 방을 만들어주는 메소드
     * @param name 지정할 방 이름
     * @return 제작된 방 ChatRoomDTO 타입 사용
     */
    public static ChatRoomDTO create(String name) {
        ChatRoomDTO room = new ChatRoomDTO();

        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }
}
