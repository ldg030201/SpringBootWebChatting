package com.ldg.webchat.api.web;

import com.ldg.webchat.api.entity.Chat;
import com.ldg.webchat.api.service.APIService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * api 컨트롤러
 */
@RestController
@RequestMapping("/api")
public class APIController {
    private final APIService apiService;

    public APIController(APIService apiService) {
        this.apiService = apiService;
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

    @PostMapping("/insert-message")
    public void insertMessage(@RequestParam("message") String message, @RequestParam("roomId") String roomId) {
        Integer userId = 1;

        apiService.insertMessage(message, userId, roomId);
    }

    @PostMapping("/select-message")
    public List<Chat> selectMessage(@RequestParam("roomId") String roomId) {
        return apiService.selectMessage(roomId);
    }
}
