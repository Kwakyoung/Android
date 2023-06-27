package com.example.project01_kygtalk.friend;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kygtalk.MainActivity;
import com.example.project01_kygtalk.databinding.ItemFirendRecvBinding;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder>{

    ItemFirendRecvBinding binding;
    ArrayList<FriendDTO> list ;
    Context context;  // 액티비티로 이동하기 위해선 컨텍스트


    public FriendAdapter(ArrayList<FriendDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext()); // 리사이클러에서만 가능
        binding = ItemFirendRecvBinding.inflate( inflater,parent,false);
        return new ViewHolder(binding);
    }

    // 리사이클러뷰의 칸마다의 데이터 연결이나 이벤트 연결하는 메소드.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.imgvProfile.setImageResource(list.get(position).getResImgId());
        holder.binding.tvName.setText(list.get(position).getName());
        holder.binding.lnFriend.setOnClickListener(v -> {
                Intent intent = new Intent(context, FriendDetailActivity.class);
                // 인텐트 객체를 통해서 선택 된 아이템을 => FriendDetailActivity로 전송

                // Web ( get방식으로 id값을 Controller에 전달 => id를 통해서 데이터 한건을 조회 => Vo )
                intent.putExtra("dto",list.get(position));
                context.startActivity(intent); // 받아오려면
        });


        String [] dialogItems = {"즐겨찾기에 추가", "이름 변경", "숨김", "차단"};   // 꾹눌렀을때 나오는것들 배열로 묶어서 선언
        holder.binding.lnFriend.setOnLongClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(list.get(position).getName());  // 제목 부분
            builder.setItems(dialogItems , ((dialog, idx) -> {
                if(dialogItems[idx].equals("차단")){
                    list.remove(position);
                    notifyDataSetChanged(); // adapter에 있는 메소드 이거는 내부에 있는 리스트가 바뀌었다는것을 어댑터에 전달하고 어댑터는 내용을 다시 그린다.
                    dialog.dismiss(); // 다이얼로그를 안보이게 처리
                }
            }));

            builder.create().show();
            return true;  // 꾹 누르는 메소드는 리턴이 필요함  setOnLong 클릭 리스너
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
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
