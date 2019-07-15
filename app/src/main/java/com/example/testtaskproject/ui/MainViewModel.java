package com.example.testtaskproject.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.testtaskproject.data.RepositoryImpl;
import com.example.testtaskproject.data.models.Animal;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private final LiveData<List<Animal>> catsLiveData;
    private final Observer<List<Animal>> catsObserver;
    private AnimalsListAdapter catsAdapter = new AnimalsListAdapter();
    private AnimalsListAdapter dogsAdapter = new AnimalsListAdapter();

    public MainViewModel(@NonNull Application application) {
        super(application);
        catsLiveData = RepositoryImpl.getInstance().getCats();
        catsObserver = new Observer<List<Animal>>() {
            @Override
            public void onChanged(List<Animal> animals) {
                catsAdapter.setItems(animals);
            }
        };
        catsLiveData.observeForever(catsObserver);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        catsLiveData.removeObserver(catsObserver);
    }

    public AnimalsListAdapter getCatsAdapter() {
        return catsAdapter;
    }

    public AnimalsListAdapter getDogsAdapter() {
        return dogsAdapter;
    }
}
