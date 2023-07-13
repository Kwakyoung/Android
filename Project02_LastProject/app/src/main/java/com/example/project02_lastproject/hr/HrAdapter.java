package com.example.project02_lastproject.hr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_lastproject.databinding.ItemRecvHrBinding;

import java.util.ArrayList;

public class HrAdapter extends RecyclerView.Adapter<HrAdapter.ViewHolder> {

    ItemRecvHrBinding binding;
    Context context;
    ArrayList<EmployeeVO> list;

    public HrAdapter(ArrayList<EmployeeVO> list) {
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        binding = ItemRecvHrBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvName.setText(list.get(position).getName());
        holder.binding.tvDepartment.setText(list.get(position).getDepartment_name());
        holder.binding.tvEmail.setText(list.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemRecvHrBinding binding;
        public ViewHolder(@NonNull ItemRecvHrBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
