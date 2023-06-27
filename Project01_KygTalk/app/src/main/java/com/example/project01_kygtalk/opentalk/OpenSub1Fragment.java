package com.example.project01_kygtalk.opentalk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_kygtalk.R;
import com.example.project01_kygtalk.chat.ChatDTO;
import com.example.project01_kygtalk.databinding.FragmentOpenSub1Binding;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class OpenSub1Fragment extends Fragment {

    FragmentOpenSub1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOpenSub1Binding.inflate(inflater,container,false);


//        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);  // 리사이클이 횡으로

        binding.recvLivePoorchat.setAdapter(new ChatAdapter(getlist(),getContext()));
        binding.recvLivePoorchat.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recvImg1.setAdapter(new ChatRoomAdapter(getContext()));
        binding.recvImg1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recvWorkHolic.setAdapter(new WorkHolicAdapter(getContext()));
        binding.recvWorkHolic.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        return binding.getRoot();

    }
    public ArrayList<PoorChatDTO> getlist(){
        ArrayList<PoorChatDTO> list = new ArrayList<>();

        list.add(new PoorChatDTO("조은평","ㅋㅋ"));
        list.add(new PoorChatDTO("김수봉","안녕하세요"));
        list.add(new PoorChatDTO("곽영균","반갑습니다"));
        list.add(new PoorChatDTO("이진성","ㅎㅇ"));
        list.add(new PoorChatDTO("김영문","ㅂㅂ"));
        list.add(new PoorChatDTO("김건호","배고파"));
        list.add(new PoorChatDTO("문병준","잠와"));

        return list;
    }

}