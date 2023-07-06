package com.example.cloneyoutubemusic.Round;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cloneyoutubemusic.databinding.ItemMoodsBinding;

public class AdapterMoods extends RecyclerView.Adapter<AdapterMoods.ViewHolder> {
    ItemMoodsBinding binding;
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemMoodsBinding.inflate(inflater,parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.every.getContext();
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemMoodsBinding binding;
        public ViewHolder(@NonNull ItemMoodsBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
