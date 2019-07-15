package com.example.testtaskproject.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testtaskproject.data.models.Animal;
import com.example.testtaskproject.databinding.ItemAnimalBinding;

import java.util.ArrayList;
import java.util.List;

public class AnimalsListAdapter extends RecyclerView.Adapter<AnimalsListAdapter.VH> {

    private List<Animal> items = new ArrayList<>();

    public void setItems(List<Animal> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAnimalBinding binding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.getContext()));
        binding.setViewModel(new AnimalItemViewModel());
        return new VH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder {

        private ItemAnimalBinding binding;

        VH(ItemAnimalBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Animal animal) {
            binding.getViewModel().start(animal);
            binding.getViewModel().itemPosition.set(String.valueOf(getAdapterPosition()));
        }
    }
}
