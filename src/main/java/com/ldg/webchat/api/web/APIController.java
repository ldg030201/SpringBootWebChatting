package com.ldg.webchat.api.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class APIController {
    @GetMapping("/google-trends-rss")
    public String googleTrendsRss() {
        String url = "https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=KR";

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
