package com.ldg.webchat.chat.web;

import com.ldg.webchat.chat.entity.ChatRoomDTO;
import com.ldg.webchat.chat.service.ChatService;
import com.ldg.webchat.user.entity.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("/chat")
public class RoomController {
    private final ChatService chatService;

    public RoomController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping(value = "/room")
    public String create(@RequestParam String name, @RequestParam Boolean isSave, RedirectAttributes rttr) {
        rttr.addFlashAttribute("roomName", chatService.createChatRoomDTO(name, isSave));

        return "redirect:/chat/room";
    }

    @GetMapping("/room")
    public void getRoom(String roomId, Model model, HttpSession session) {
        UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
        if (userInfo == null) {
            userInfo = UserDTO.builder()
                    .userId(UUID.randomUUID().toString())
                    .build();
            session.setAttribute("userInfo", userInfo);
        }

        model.addAttribute("list", chatService.findAllRooms());
        ChatRoomDTO chatRoom = chatService.findRoomById(roomId);
        if (chatRoom != null) {
            chatRoom.setUserId(userInfo.getUserId());
        } else {
            chatRoom = new ChatRoomDTO();
        }

        model.addAttribute("room", chatRoom);
    }
}
