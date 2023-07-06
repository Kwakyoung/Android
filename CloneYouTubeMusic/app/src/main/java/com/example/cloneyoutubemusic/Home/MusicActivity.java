package com.example.cloneyoutubemusic.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cloneyoutubemusic.Home.DTO.HomeDTO;
import com.example.cloneyoutubemusic.databinding.ActivityMusicBinding;

public class MusicActivity extends AppCompatActivity {
    ActivityMusicBinding binding;
    HomeDTO dto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMusicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String a = "dto";
        dto = (HomeDTO) getIntent().getSerializableExtra("dto");


        binding.imgvTitle.setImageResource(dto.getMusic());
        binding.tvTitle.setText(dto.getTitle());
        binding.tvSinger.setText(dto.getSinger());

//        binding.imgvTitle.setImageResource(dto1.getMusic());
//        binding.tvTitle.setText(dto1.getTitle());
//        binding.tvSinger.setText(dto1.getSinger());







    }
}