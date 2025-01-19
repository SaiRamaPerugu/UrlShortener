package com.ram.urlshortener.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Slf4j
@Repository
public class UrlDao implements  Dao {

    private final JdbcTemplate jdbcTemplate;

    public UrlDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String checkUrlExists(String url) {
        String sql = "SELECT short_url FROM url_mapping where long_url = '" + url + "'";
        String urlFromDb = "";
        try {
            urlFromDb = jdbcTemplate.queryForObject(sql, String.class);
            log.info("Url from DB: " + urlFromDb);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            log.info("Long url not found in database");
        }

        return urlFromDb;
    }

    @Override
    public int insertUrl(String longUrl, String shortUrl) {
         int result;
         try {
             result = jdbcTemplate.update("INSERT INTO url_mapping(ID, long_url, short_url) VALUES(?,?,?)", 2,longUrl, shortUrl);
             log.info("Inserted url: " + shortUrl);
         } catch(Exception ex) {
             log.error("Error while inserting url: {}", ex.getMessage());
             throw new RuntimeException(ex.getMessage());
         }
         return result;
    }
}
