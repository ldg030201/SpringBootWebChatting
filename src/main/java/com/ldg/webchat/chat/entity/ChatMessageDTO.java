package com.ldg.webchat.chat.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 채팅 DTO
 */
@Getter
@Setter
public class ChatMessageDTO {
    private String roomId; //방 아이디
    private String writer; //작성자
    private String writerId;
    private String message; //메시지
}
