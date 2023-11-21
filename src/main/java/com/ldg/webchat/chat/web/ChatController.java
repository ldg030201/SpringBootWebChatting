package com.ldg.webchat.chat.web;

import com.ldg.webchat.chat.entity.ChatMessageDTO;
import com.ldg.webchat.user.entity.UserDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * 채팅 메인 컨트롤러
 */
@Controller
public class ChatController {
    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달

    public ChatController(SimpMessagingTemplate template) {
        this.template = template;
    }

    /**
     * 입장 시 작동되는 컨트롤러
     * @param message 입장 시 받는 메시지 객체
     */
    @MessageMapping(value = "/chat/enter")
    public void enter(ChatMessageDTO message) {
        message.setMessage(message.getWriter() + "님이 채팅방에 참여하였습니다.");
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

    /**
     * 채팅 작성 시 작동되는 컨트롤러
     * @param message 작성한 메시지 담은 객체
     */
    @MessageMapping(value = "/chat/message")
    public void message(ChatMessageDTO message, @SessionAttribute("userInfo") UserDTO userInfo) {
        message.setWriterId(userInfo.getUserId());
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}
