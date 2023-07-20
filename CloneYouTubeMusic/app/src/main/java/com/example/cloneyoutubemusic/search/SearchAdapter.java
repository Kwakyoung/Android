package com.example.cloneyoutubemusic.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cloneyoutubemusic.databinding.ItemSearchMusicBinding;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

    ItemSearchMusicBinding binding;

    public SearchAdapter(Context context, ArrayList<SearchVO> list) {
        this.context = context;
        this.list = list;
    }

    Context context;
    ArrayList<SearchVO> list;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemSearchMusicBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.itemMusic.setImageResource(list.get(position).getMusic());
        holder.binding.itemTitle.setText(list.get(position).getTitle());
        holder.binding.homeSinger.setText(list.get(position).getSinger());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemSearchMusicBinding binding;
        public ViewHolder(@NonNull ItemSearchMusicBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
