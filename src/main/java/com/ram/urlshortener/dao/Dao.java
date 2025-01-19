package com.ram.urlshortener.dao;

public interface Dao {

    public String checkUrlExists(String url);

    public int insertUrl(String longUrl, String shortUrl);

}
