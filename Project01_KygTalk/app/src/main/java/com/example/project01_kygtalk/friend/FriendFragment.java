package com.example.project01_kygtalk.friend;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_kygtalk.MainActivity;
import com.example.project01_kygtalk.R;
import com.example.project01_kygtalk.databinding.FragmentFriendBinding;

import java.util.ArrayList;


public class FriendFragment extends Fragment {

    FragmentFriendBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFriendBinding.inflate(inflater, container, false);
//      View v = inflater.inflate(R.layout.fragment_friend, container, false);

        binding.recvFriend.setAdapter(new FriendAdapter(getlist(), getContext()));
        binding.recvFriend.setLayoutManager(new LinearLayoutManager(getContext()));

//        Intent intent = new Intent(getContext(), MainActivity.class);
//        startActivity(intent);

        return binding.getRoot(); // 최상위 레이아웃을 의미 (ex -Framelayout , leanear 등등)
    }
    public ArrayList<FriendDTO> getlist(){
        ArrayList<FriendDTO> list = new ArrayList<>();

        list.add(new FriendDTO(R.drawable.img2,"영균","ㅎㅇ"));
        list.add(new FriendDTO(R.drawable.img3,"은평","zZ"));
        list.add(new FriendDTO(R.drawable.img4,"수봉","ㅋㅋ"));
        list.add(new FriendDTO(R.drawable.img5,"진성","안녕"));
        list.add(new FriendDTO(R.drawable.img6,"영문","바이"));


        return list;
    }

}