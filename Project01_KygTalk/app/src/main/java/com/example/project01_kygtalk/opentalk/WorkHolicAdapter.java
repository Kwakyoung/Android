package com.example.project01_kygtalk.opentalk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kygtalk.R;
import com.example.project01_kygtalk.databinding.ItemWorkHolicBinding;

public class WorkHolicAdapter extends RecyclerView.Adapter<WorkHolicAdapter.ViewHolder>{
    ItemWorkHolicBinding binding;
    Context context;

    public WorkHolicAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemWorkHolicBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.findViewById(R.id.imageView);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull ItemWorkHolicBinding binding) {
            super(binding.getRoot());
        }
    }
}
