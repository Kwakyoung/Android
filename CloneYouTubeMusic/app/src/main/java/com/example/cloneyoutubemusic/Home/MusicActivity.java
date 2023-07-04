package com.example.cloneyoutubemusic.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cloneyoutubemusic.Home.DTO.HomeDTO;
import com.example.cloneyoutubemusic.Home.DTO.HomeDTO1;
import com.example.cloneyoutubemusic.R;
import com.example.cloneyoutubemusic.databinding.ActivityMainBinding;
import com.example.cloneyoutubemusic.databinding.ActivityMusicBinding;

public class MusicActivity extends AppCompatActivity {
    ActivityMusicBinding binding;
    HomeDTO dto;
    HomeDTO1 dto1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMusicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dto = (HomeDTO) getIntent().getSerializableExtra("dto");
        dto1 = (HomeDTO1) getIntent().getSerializableExtra("dto1");

        binding.imgvTitle.setImageResource(dto.getMusic());
        binding.tvTitle.setText(dto.getTitle());
        binding.tvSinger.setText(dto.getSinger());

//        binding.imgvTitle.setImageResource(dto1.getMusic());
//        binding.tvTitle.setText(dto1.getTitle());
//        binding.tvSinger.setText(dto1.getSinger());







    }
}