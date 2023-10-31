package com.ldg.webchat.api.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * api 컨트롤러
 */
@RestController
@RequestMapping("/api")
public class APIController {
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
}
