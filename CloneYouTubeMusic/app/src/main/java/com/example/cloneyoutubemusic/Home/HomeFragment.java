package com.example.cloneyoutubemusic.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.cloneyoutubemusic.Home.Adapter.HomeAdapter;
import com.example.cloneyoutubemusic.Home.Adapter.MixAdapter;
import com.example.cloneyoutubemusic.Home.Adapter.QuickAdapter;
import com.example.cloneyoutubemusic.Home.DTO.HomeDTO;
import com.example.cloneyoutubemusic.Home.DTO.HomeDTO1;
import com.example.cloneyoutubemusic.Home.DTO.MixDTO;
import com.example.cloneyoutubemusic.Home.DTO.QuickDTO;
import com.example.cloneyoutubemusic.R;
import com.example.cloneyoutubemusic.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);

        binding.recvReplay.setAdapter(new HomeAdapter(getlist(),getlist1(),getContext()));
        binding.recvReplay.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recvQuick.setAdapter(new QuickAdapter(getQuickList(),getContext()));
        binding.recvQuick.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recvMix.setAdapter(new MixAdapter(getContext(), getMixlist()) );
        binding.recvMix.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));


        return binding.getRoot();
    }

    public ArrayList<HomeDTO> getlist(){
        ArrayList<HomeDTO> list = new ArrayList<>();
        list.add(new HomeDTO(R.drawable.melomance, "찬란한 ", "멜로망스"));
        list.add(new HomeDTO(R.drawable.lucy, "찬란한 ", "멜로망스"));
        list.add(new HomeDTO(R.drawable.quick_stray, "찬란한 ", "멜로망스"));
        list.add(new HomeDTO(R.drawable.quick_paulkim, "찬란한 ", "멜로망스"));

        return list;
    } public ArrayList<HomeDTO1> getlist1(){
        ArrayList<HomeDTO1> list1 = new ArrayList<>();
        list1.add(new HomeDTO1(R.drawable.melomance, "찬란한 ", "멜로망스"));
        list1.add(new HomeDTO1(R.drawable.lucy, "찬란한 ", "멜로망스"));
        list1.add(new HomeDTO1(R.drawable.quick_stray, "찬란한 ", "멜로망스"));
        list1.add(new HomeDTO1(R.drawable.quick_paulkim, "찬란한 ", "멜로망스"));

        return list1;
    }

    public ArrayList<QuickDTO> getQuickList() {
        ArrayList<QuickDTO> list = new ArrayList<>();
        list.add(new QuickDTO(R.drawable.lucy,R.drawable.melomance,R.drawable.quick_paulkim,R.drawable.quick_stray,
                "히어로","찬란한 하루","우린 제법 잘어울려요", "특 S-Class",
                "루시","멜로망스","폴킴","Stray Kids"));

        list.add(new QuickDTO(R.drawable.lucy,R.drawable.melomance,R.drawable.quick_paulkim,R.drawable.quick_stray,
                "히어로","찬란한 하루","우린 제법 잘어울려요", "특 S-Class",
                "루시","멜로망스","폴킴","Stray Kids"));

        return list;
    }

    public ArrayList<MixDTO> getMixlist() {
        ArrayList<MixDTO> list = new ArrayList<>();
        list.add(new MixDTO(R.drawable.user,"나만을 위한 맞춤 믹스"));
        list.add(new MixDTO(R.drawable.user1,"나만의 믹스"));

        return list;
    }
}