package com.ram.urlshortener.service;

import com.ram.urlshortener.dao.Dao;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    private final Dao dao;

    public UrlService(Dao dao) {
        this.dao = dao;
    }

    public String getShortUrl(String longUrl) {
        String url = dao.getShortUrl(longUrl);
        if(url == null || url.isEmpty()) {
            return null;
        }
        return url;
    }
}
