package com.example.and09_fragmentadapter.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and09_fragmentadapter.R;

import java.util.ArrayList;

// 2. extends로 AdapterClass를 상속받는다.
// 상속받을때 ViewHolder가 필요함.  RecyclerView.Adapter<VH> => VH : ViewHolder의 약자
public class AdapterRecv extends RecyclerView.Adapter<AdapterRecv.KygViewHolder>{

    LayoutInflater inflater;
    ArrayList<RecvDTO> list;

    public AdapterRecv(LayoutInflater inflater, ArrayList<RecvDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    // 레이아웃을 붙이고 (View) 해당하는 타입으로 ViewHolder를 만들어내는 과정의 메소드
    @NonNull
    @Override
    public KygViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recview, parent, false);
        return new KygViewHolder(v);

    }

    // ViewHolder와 Data 연결 ( 디자인 <=> ArrayList )
    @Override
    public void onBindViewHolder(@NonNull KygViewHolder holder, int i) {
        holder.imgv_profile.setImageResource(list.get(i).getImgRes());
        holder.tv_name.setText(list.get(i).getName());
        holder.tv_gender.setText(list.get(i).getGender());
        holder.tv_age.setText(list.get(i).getAge());
        holder.tv_address.setText(list.get(i).getAddress());
    }

    // 총 아이템의 개수
    @Override
    public int getItemCount() {
        return list.size();
    }





    // 1. InnerClass로 ViewHolder를 먼저 만든다.
    // 위젯들을 묶어놓은 DTO라고 생각하면됨. 리사이클러뷰는 ViewHolder를 강제한다. ( 재활용 )
    // ViewHolder는 일반 InnerClass에 RecyclerView.ViewHolder를 상속받은 구조.
    public class KygViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_profile;
        TextView tv_name, tv_gender, tv_age, tv_address;
        Button btn_detail;
        public KygViewHolder(@NonNull View v) {
            super(v);
            imgv_profile = v.findViewById(R.id.imgv_profile);
            tv_name = v.findViewById(R.id.tv_name);
            tv_age = v.findViewById(R.id.tv_age);
            tv_gender = v.findViewById(R.id.tv_gender);
            tv_address = v.findViewById(R.id.tv_address);
            btn_detail = v.findViewById(R.id.btn_detail);
        }
    }
}
