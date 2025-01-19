package com.ram.urlshortener.controller;

import com.ram.urlshortener.service.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MainController {

    private final UrlService urlService;

    public MainController(UrlService urlService) {
        this.urlService = urlService;
    }

    @RequestMapping("/getShortUrl")
    public String getShortUrl(String url) {
        log.info("Long url {}", url);
        String shortUrl = urlService.getShortUrl(url);
        log.info("Short url {}", shortUrl);
        return  shortUrl;
    }
}
