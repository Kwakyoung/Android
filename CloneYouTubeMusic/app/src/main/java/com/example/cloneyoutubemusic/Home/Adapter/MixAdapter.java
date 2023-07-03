package com.example.cloneyoutubemusic.Home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cloneyoutubemusic.Home.DTO.MixDTO;
import com.example.cloneyoutubemusic.databinding.ItemMixBinding;

import java.util.ArrayList;

public class MixAdapter extends RecyclerView.Adapter<MixAdapter.ViewHolder> {

    ItemMixBinding binding;
    Context context;
    ArrayList<MixDTO> list;

    public MixAdapter(Context context, ArrayList<MixDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemMixBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.binding.itemMusic.setImageResource(list.get(position).getItem_music());
       holder.binding.itemTxt.setText(list.get(position).getItem_txt());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
            ItemMixBinding binding;
        public ViewHolder(@NonNull ItemMixBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
