package com.example.and09_fragmentadapter.melon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;

public class AdapterMelon extends RecyclerView.Adapter<AdapterMelon.melon>{

    LayoutInflater inflater;
    ArrayList<MelonDTO> list;

    public AdapterMelon(LayoutInflater inflater, ArrayList<MelonDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public melon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =inflater.inflate(R.layout.item_melonv,parent,false);
        return new melon(v);
    }

    @Override
    public void onBindViewHolder(@NonNull melon holder, int i) {
     holder.imgv_chart.setImageResource(list.get(i).getImgRes());
     holder.tv_title.setText(list.get(i).getTv_title());
     holder.tv_number.setText(list.get(i).getTv_number());
     holder.tv_group.setText(list.get(i).getTv_group());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class melon extends RecyclerView.ViewHolder {

        ImageView imgv_chart, imgv_play;
        TextView tv_number, tv_title, tv_group;


        public melon(@NonNull View v) {
            super(v);

            imgv_chart = v.findViewById(R.id.imgv_chart);
            imgv_play = v.findViewById(R.id.imgv_play);
            tv_number = v.findViewById(R.id.tv_number);
            tv_title = v.findViewById(R.id.tv_title);
            tv_group = v.findViewById(R.id.tv_group);
        }
    }
}

