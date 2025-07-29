package com.matheuskya.url_shortener_service.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "urls")
public class Url {
    @Id
    @GeneratedValue
    private String id;
    private String shortCode;
    private String longUrl;

    public Url() {

    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
