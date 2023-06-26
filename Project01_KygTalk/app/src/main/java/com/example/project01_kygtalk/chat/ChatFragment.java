package com.example.project01_kygtalk.chat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_kygtalk.R;
import com.example.project01_kygtalk.databinding.FragmentChatBinding;
import com.example.project01_kygtalk.databinding.FragmentFriendBinding;
import com.example.project01_kygtalk.friend.FriendAdapter;
import com.example.project01_kygtalk.friend.FriendDTO;

import java.util.ArrayList;

public class ChatFragment extends Fragment {
    FragmentChatBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentChatBinding.inflate(inflater, container, false);

        binding.chatFriend.setAdapter(new ChatAdapter(getlist(), getContext()));
        binding.chatFriend.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();
    }

    public ArrayList<ChatDTO> getlist() {
        ArrayList<ChatDTO> list = new ArrayList<>();

        list.add(new ChatDTO(R.drawable.img2, "영균", "ㅎㅇ","10:10"));
        list.add(new ChatDTO(R.drawable.img3, "은평", "zZ","10:10"));
        list.add(new ChatDTO(R.drawable.img4, "수봉", "ㅋㅋ","10:10"));
        list.add(new ChatDTO(R.drawable.img5, "진성", "안녕","10:10"));
        list.add(new ChatDTO(R.drawable.img6, "영문", "바이","10:10"));

        return list;
    }
}