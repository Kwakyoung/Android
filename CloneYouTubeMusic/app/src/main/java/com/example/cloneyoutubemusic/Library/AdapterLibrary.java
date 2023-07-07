package com.example.cloneyoutubemusic.Library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cloneyoutubemusic.databinding.ItemLibararyBinding;

import java.util.ArrayList;

public class AdapterLibrary extends RecyclerView.Adapter<AdapterLibrary.ViewHolder>{

    ItemLibararyBinding binding;
    ArrayList<LibraryDTO> list;
    Context context;

    public AdapterLibrary(ArrayList<LibraryDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemLibararyBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.imgvLibraryMusic.setImageResource(list.get(position).getImgv_library_music());
        holder.binding.tvLibraryTitle.setText(list.get(position).getTv_library_title());
        holder.binding.tvLibrarySinger.setText(list.get(position).getTv_library_singer());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemLibararyBinding binding;
        public ViewHolder(@NonNull ItemLibararyBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
