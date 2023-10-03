package com.ldg.webchat.chat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/chat")
    public String chatGET(){
        return "chat/chat";
    }
}
