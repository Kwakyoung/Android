package com.example.project01_kygtalk.friend;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kygtalk.databinding.ItemFirendRecvBinding;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder>{

    ItemFirendRecvBinding binding;
    ArrayList<FriendDTO> list ;

    public FriendAdapter(ArrayList<FriendDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemFirendRecvBinding.inflate( inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    // 1. 위젯들을 묶어서 저장해놓을 객체 ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemFirendRecvBinding binding;
        public ViewHolder(@NonNull ItemFirendRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
