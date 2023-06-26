package com.example.project01_kygtalk.chat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kygtalk.databinding.ItemChatRecvBinding;
import com.example.project01_kygtalk.databinding.ItemFirendRecvBinding;



import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>{

    ItemChatRecvBinding binding;
    ArrayList<ChatDTO> list ;
    Context context;

    public ChatAdapter(ArrayList<ChatDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext()); // 리사이클러에서만 가능
        binding = ItemChatRecvBinding.inflate( inflater,parent,false);
        return new ViewHolder(binding);
    }

    // 리사이클러뷰의 칸마다의 데이터 연결이나 이벤트 연결하는 메소드.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.imgvProfile.setImageResource(list.get(position).getResImgId());
        holder.binding.tvName.setText(list.get(position).getName());
        holder.binding.tvTxt.setText(list.get(position).getMsg());
        holder.binding.tvTime.setText(list.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // 1. 위젯들을 묶어서 저장해놓을 객체 ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemChatRecvBinding binding;

        public ViewHolder(@NonNull ItemChatRecvBinding binding) {
            super(binding.getRoot());
            this.binding=binding;


        }


    }

}
