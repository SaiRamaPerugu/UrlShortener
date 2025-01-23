package com.ram.urlshortener.service;

import com.ram.urlshortener.dao.Dao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
@Slf4j
public class UrlService {

    private final Dao dao;

    public UrlService(Dao dao) {
        this.dao = dao;
    }

    public String getShortUrl(String longUrl) {
        String shortUrl = "";
        try {
            shortUrl = dao.checkUrlExists(longUrl);
            log.info("Method getShortUrl : {} ", shortUrl);
            if (shortUrl != null && !shortUrl.isEmpty()) {
                log.info("Long url exists, returning the same URL: {}", shortUrl);
                return shortUrl;
            }
            log.info("Long url does not exist");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] hash = messageDigest.digest(longUrl.getBytes());
            String base64String = Base64.getEncoder().encodeToString(hash);
            log.info("Base64 encoded String: {}", base64String);
            shortUrl = base64String.substring(0,6);
            int result = dao.insertUrl(longUrl,"http://localhost/" + shortUrl);
            log.info("Insert url result: {}", result);
        } catch(NoSuchAlgorithmException noSuchAlgorithmException) {
            log.info("Error while generating Hash key");
            log.error("No such algorithm: {}", noSuchAlgorithmException.getMessage());
        } catch(Exception exception) {
            log.error("Error retrieving the URL from Database, {}", exception.getMessage());
            throw new RuntimeException("Error retrieving the URL from Database" );
        }
        return "http://localhost/" + shortUrl;
    }

}
