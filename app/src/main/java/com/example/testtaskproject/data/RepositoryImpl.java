package com.example.testtaskproject.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.testtaskproject.data.models.Animal;
import com.example.testtaskproject.data.models.responses.GetAnimalsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryImpl implements Repository {

    private ApiService apiService;
    private static RepositoryImpl INSTANCE;

    public static RepositoryImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RepositoryImpl();
        }
        return INSTANCE;
    }

    private RepositoryImpl() {
        apiService = NetworkService.getInstance().getApiService();
    }

    @Override
    public LiveData<List<Animal>> getCats() {
        final MutableLiveData<List<Animal>> liveData = new MutableLiveData<>();
        apiService.getAnimals("cat").enqueue(new Callback<GetAnimalsResponse>() {
            @Override
            public void onResponse(Call<GetAnimalsResponse> call, Response<GetAnimalsResponse> response) {
                if (response.body() != null) {
                    liveData.postValue(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<GetAnimalsResponse> call, Throwable t) {

            }
        });
        return liveData;
    }
}
