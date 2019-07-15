package com.example.testtaskproject.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static NetworkService INSTANCE;
    private static final String BASE_URL = "http://kot3.com/";
    private Retrofit retrofit;

    private NetworkService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ApiService getApiService() {
        return retrofit.create(ApiService.class);
    }

    public static NetworkService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NetworkService();
        }
        return INSTANCE;
    }
}
