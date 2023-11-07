package com.ldg.webchat.api.web;

import com.ldg.webchat.api.entity.Chat;
import com.ldg.webchat.api.repository.ChatRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * api 컨트롤러
 */
@RestController
@RequestMapping("/api")
public class APIController {
    private final ChatRepository chatRepository;

    public APIController(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    /**
     * 구글 트렌드 rss값을 html 코드로 변환
     * @return 변환된 html 코드값을 String타입으로 리턴
     */
    @GetMapping("/google-trends-rss")
    public String googleTrendsRss() {
        String url = "https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=KR";

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    @PostMapping("/jpa_test")
    public void jpaTest(@RequestParam("msg") String msg) {
        Chat chat = new Chat();
        chat.setChat(msg);

        chatRepository.save(chat);
    }
}
