package com.ldg.webchat.chat.service;

import com.ldg.webchat.chat.entity.ChatRoomDTO;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository //추후 db로 변경
public class ChatService {
    private Map<String, ChatRoomDTO> chatRoomDTOMap;

    @PostConstruct
    private void init() {
        chatRoomDTOMap = new LinkedHashMap<>();
    }

    public List<ChatRoomDTO> findAllRooms() {
        List<ChatRoomDTO> result = new ArrayList<>(chatRoomDTOMap.values());
        Collections.reverse(result);

        return result;
    }

    public ChatRoomDTO findRoomById(String id) {
        if (id == null) {
            return new ChatRoomDTO();
        }

        return chatRoomDTOMap.get(id);
    }

    public ChatRoomDTO createChatRoomDTO(String name) {
        ChatRoomDTO room = ChatRoomDTO.create(name);
        chatRoomDTOMap.put(room.getRoomId(), room);

        return room;
    }
}
