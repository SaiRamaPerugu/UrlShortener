package com.ram.urlshortener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class UrlShortnerApplication {

    public static void main(String[] args) {

        SpringApplication.run(UrlShortnerApplication.class, args);
    }

}
