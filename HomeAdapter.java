package com.example.cloneyoutubemusic.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cloneyoutubemusic.R;
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
        holder.binding.itemMusic1.setImageResource(list.get(position).getMusic1());
        holder.binding.itemTitle1.setText(list.get(position).getTitle1());
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
