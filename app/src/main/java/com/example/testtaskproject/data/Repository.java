package com.example.testtaskproject.data;

import androidx.lifecycle.LiveData;

import com.example.testtaskproject.data.models.Animal;

import java.util.List;

public interface Repository {

    LiveData<List<Animal>> getCats();
}
