package com.ldg.webchat.chat.service;

import com.ldg.webchat.chat.entity.ChatRoomDTO;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 채팅 서비스
 */
@Repository //추후 db로 변경
public class ChatService {
    private Map<String, ChatRoomDTO> chatRoomDTOMap; //여러 방을 보관하는 Map

    @PostConstruct
    private void init() {
        chatRoomDTOMap = new LinkedHashMap<>();
    }

    /**
     * 모든 채팅방 찾기
     * @return 채팅방 목록
     */
    public List<ChatRoomDTO> findAllRooms() {
        List<ChatRoomDTO> result = new ArrayList<>(chatRoomDTOMap.values());
        Collections.reverse(result);

        return result;
    }

    /**
     * 채팅방 아이디를 이용하여 방 찾기
     * @param id 방 아이디
     * @return
     */
    public ChatRoomDTO findRoomById(String id) {
        if (id == null) {
            return new ChatRoomDTO();
        }

        return chatRoomDTOMap.get(id);
    }

    /**
     * 채팅방 만들기
     * @param name 채팅방 제목
     * @return 만들어진 채팅방 값 ChatRoomDTO 사용
     */
    public ChatRoomDTO createChatRoomDTO(String name, Boolean isSave) {
        ChatRoomDTO room = new ChatRoomDTO();

        if (isSave) {
            name = "[저장]" + name;
        }

        room.setRoomId(UUID.randomUUID().toString());
        room.setName(name);
        room.setIsSave(isSave);

        chatRoomDTOMap.put(room.getRoomId(), room);

        return room;
    }
}
