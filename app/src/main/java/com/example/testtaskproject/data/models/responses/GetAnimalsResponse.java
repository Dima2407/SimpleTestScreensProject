package com.example.testtaskproject.data.models.responses;

import com.example.testtaskproject.data.models.Animal;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetAnimalsResponse {

    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<Animal> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Animal> getData() {
        return data;
    }

    public void setData(List<Animal> data) {
        this.data = data;
    }
}
