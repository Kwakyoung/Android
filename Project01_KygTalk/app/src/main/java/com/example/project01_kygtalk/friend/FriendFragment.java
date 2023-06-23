package com.example.project01_kygtalk.friend;

import android.os.Binder;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        binding.recvFriend.setAdapter(new FriendAdapter(getlist()));
        binding.recvFriend.setLayoutManager(new LinearLayoutManager(getContext()));



        return binding.getRoot(); // 최상위 레이아웃을 의미 (ex -Framelayout , leanear 등등)
    }
    public ArrayList<FriendDTO> getlist(){
        ArrayList<FriendDTO> list = new ArrayList<>();

        list.add(new FriendDTO(R.drawable.img2,"이름","안녕"));
        return list;
    }

}