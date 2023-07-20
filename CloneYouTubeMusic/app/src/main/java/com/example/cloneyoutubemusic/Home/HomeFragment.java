package com.example.cloneyoutubemusic.Home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cloneyoutubemusic.Home.DTO.HomeDTO;
import com.example.cloneyoutubemusic.Home.DTO.MixDTO;
import com.example.cloneyoutubemusic.Home.DTO.QuickDTO;
import com.example.cloneyoutubemusic.R;
import com.example.cloneyoutubemusic.databinding.FragmentHomeBinding;
import com.example.cloneyoutubemusic.search.SearchActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);

        binding.search.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), SearchActivity.class);
            startActivity(intent);
        });

        binding.recvReplay.setAdapter(new HomeAdapter(getlist(),getContext()));
        binding.recvReplay.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recvQuick.setAdapter(new QuickAdapter(getQuickList(),getContext()));
        binding.recvQuick.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recvMix.setAdapter(new MixAdapter(getContext(), getMixlist()) );
        binding.recvMix.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));


        return binding.getRoot();
    }

    public ArrayList<HomeDTO> getlist(){
        ArrayList<HomeDTO> list = new ArrayList<>();
        list.add(new HomeDTO(R.drawable.melomance, R.drawable.art,"이름긴거 테스트 아아아아아아아아아아아암ㅁㅁㅁㅁㅁㅁㅁ ", "예술이야","멜로망스", "싸이"));
        list.add(new HomeDTO(R.drawable.lucy, R.drawable.pray,"히어로 ", "기도","루시","비투비"));
        list.add(new HomeDTO(R.drawable.quick_stray,R.drawable.chamgo, "특 S-Class ", "참고사항","Stray Kids","이무진"));
        list.add(new HomeDTO(R.drawable.quick_paulkim, R.drawable.made_sound, "우린 제법 잘어울려요 ", "미친소리","폴킴","이예준"));

        return list;
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