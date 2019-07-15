package com.example.testtaskproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStore;

import android.os.Bundle;
import android.view.View;

import com.example.testtaskproject.R;
import com.example.testtaskproject.data.RepositoryImpl;
import com.example.testtaskproject.data.models.Animal;
import com.example.testtaskproject.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.flContainer, new ListFragment(), ListFragment.class.getSimpleName())
                .commit();
        binding.setViewModel(viewModel);
    }

    public MainViewModel getViewModel() {
        return viewModel;
    }
}
