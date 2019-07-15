package com.example.testtaskproject.data.models;

import com.google.gson.annotations.SerializedName;

public class Animal {

    @SerializedName("url")
    private String url;
    @SerializedName("title")
    private String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
