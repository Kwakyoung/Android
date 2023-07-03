package com.example.cloneyoutubemusic.Home.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cloneyoutubemusic.Home.DTO.HomeDTO;
import com.example.cloneyoutubemusic.Home.MusicActivity;
import com.example.cloneyoutubemusic.databinding.ItemHomeBinding;

import java.util.ArrayList;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    ItemHomeBinding binding;
    Context context;

    ArrayList<HomeDTO> list ;

    public HomeAdapter(Context context, ArrayList<HomeDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemHomeBinding.inflate(inflater,parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.itemMusic.setImageResource(list.get(position).getMusic());
        holder.binding.itemTitle.setText(list.get(position).getTitle());
//        holder.binding.itemMusic1.setImageResource(list.get(position).getMusic1());
//        holder.binding.itemTitle1.setText(list.get(position).getTitle1());
        holder.binding.homeSinger.setText(list.get(position).getSinger());
//        holder.binding.homeSinger1.setText(list.get(position).getSinger1());
        holder.binding.relativHome.setOnClickListener(v -> {
            Intent intent = new Intent(context, MusicActivity.class);

            // list.get() 을 받아오려면 DTO에 Serializable 처리해주기
            intent.putExtra("dto",list.get(position));
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemHomeBinding binding;

        public ViewHolder(@NonNull ItemHomeBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
