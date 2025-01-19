package com.ram.urlshortener.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UrlDao implements  Dao {

    private final JdbcTemplate jdbcTemplate;

    public UrlDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String getShortUrl(String url) {
        String sql = "SELECT short_url FROM url_mapping where long_url = '" + url + "'";
        return jdbcTemplate.queryForObject(sql, String.class);
    }
}
