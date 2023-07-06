package com.example.cloneyoutubemusic.Round;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cloneyoutubemusic.databinding.ItemRoundAlbumBinding;

import java.util.ArrayList;

public class AdapterRoundAlbum extends RecyclerView.Adapter<AdapterRoundAlbum.ViewHolder>{

    ItemRoundAlbumBinding binding;
    ArrayList<AlbumDTO> list;
    Context context;

    public AdapterRoundAlbum(ArrayList<AlbumDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemRoundAlbumBinding.inflate(inflater,parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.imgvAlbum.setImageResource(list.get(position).getImgv_album());
        holder.binding.tvAlbumTitle.setText(list.get(position).getTv_album_title());
        holder.binding.tvAlbumSinger.setText(list.get(position).getTv_album_singer());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemRoundAlbumBinding binding;
        public ViewHolder(@NonNull ItemRoundAlbumBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
