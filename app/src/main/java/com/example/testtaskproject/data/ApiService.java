package com.example.testtaskproject.data;

import com.example.testtaskproject.data.models.responses.GetAnimalsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("xim/api.php")
    Call<GetAnimalsResponse> getAnimals(@Query("query") String query);
}
