package com.ram.urlshortener.controller;

import com.ram.urlshortener.service.UrlService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final UrlService urlService;

    public MainController(UrlService urlService) {
        this.urlService = urlService;
    }

    @RequestMapping("/getShortUrl")
    public String getShortUrl(String url) {
        System.out.println(url);
        return urlService.getShortUrl(url);
    }
}
