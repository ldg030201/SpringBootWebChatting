package com.ldg.webchat.chat.web;

import com.ldg.webchat.chat.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/chat")
public class RoomController {
    private final ChatService chatService;

    public RoomController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping(value = "/room")
    public String create(@RequestParam String name, RedirectAttributes rttr) {
        rttr.addFlashAttribute("roomName", chatService.createChatRoomDTO(name));

        return "redirect:/chat/room";
    }

    @GetMapping("/room")
    public void getRoom(String roomId, Model model) {
        model.addAttribute("list", chatService.findAllRooms());
        model.addAttribute("room", chatService.findRoomById(roomId));
    }
}
