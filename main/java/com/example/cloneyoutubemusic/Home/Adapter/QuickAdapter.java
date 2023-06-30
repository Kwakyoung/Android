package com.example.cloneyoutubemusic.Home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cloneyoutubemusic.Home.DTO.QuickDTO;
import com.example.cloneyoutubemusic.databinding.ItemQuickBinding;

import java.util.ArrayList;

public class QuickAdapter extends RecyclerView.Adapter<QuickAdapter.ViewHolder>{

    ItemQuickBinding binding;

    public QuickAdapter(ArrayList<QuickDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    ArrayList<QuickDTO> list;
    Context context;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemQuickBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.itemMusic.setImageResource(list.get(position).getItem_music());
        holder.binding.itemTitle.setText(list.get(position).getItem_title());
        holder.binding.itemSinger.setText(list.get(position).getItem_singer());

        holder.binding.itemMusic1.setImageResource(list.get(position).getItem_music1());
        holder.binding.itemTitle1.setText(list.get(position).getItem_title1());
        holder.binding.itemSinger1.setText(list.get(position).getItem_singer1());

        holder.binding.itemMusic2.setImageResource(list.get(position).getItem_music2());
        holder.binding.itemTitle2.setText(list.get(position).getItem_title2());
        holder.binding.itemSinger2.setText(list.get(position).getItem_singer2());

        holder.binding.itemMusic3.setImageResource(list.get(position).getItem_music3());
        holder.binding.itemTitle3.setText(list.get(position).getItem_title3());
        holder.binding.itemSinger3.setText(list.get(position).getItem_singer3());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemQuickBinding binding;
        public ViewHolder(@NonNull ItemQuickBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
