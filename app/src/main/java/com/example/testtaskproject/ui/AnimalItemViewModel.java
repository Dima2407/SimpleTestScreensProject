package com.example.testtaskproject.ui;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.testtaskproject.data.models.Animal;

public class AnimalItemViewModel extends ViewModel {

    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> imageUrl = new ObservableField<>();
    public ObservableField<String> itemPosition = new ObservableField<>();

    public void start(Animal animal) {
        title.set(animal.getTitle());
        imageUrl.set(animal.getUrl());
    }
}
