package com.example.project01_kygtalk.opentalk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kygtalk.databinding.ItemLivePoorChatBinding;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>{
    ItemLivePoorChatBinding binding;
    ArrayList<PoorChatDTO> list;
    Context context;

    public ChatAdapter(ArrayList<PoorChatDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemLivePoorChatBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.nickname.setText(list.get(position).getNickname());
        holder.binding.txt.setText(list.get(position).getTxt());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder {

        ItemLivePoorChatBinding binding;
        public ViewHolder(@NonNull ItemLivePoorChatBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
