package com.example.cloneyoutubemusic.Round;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cloneyoutubemusic.databinding.ItemTopsongBinding;

public class AdapterTopSong extends RecyclerView.Adapter<AdapterTopSong.ViewHolder> {

    ItemTopsongBinding binding;
    Context context;

    public AdapterTopSong(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemTopsongBinding.inflate(inflater,parent,false);

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

        ItemTopsongBinding binding;
        public ViewHolder(@NonNull ItemTopsongBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
