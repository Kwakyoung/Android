package com.example.cloneyoutubemusic.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cloneyoutubemusic.Home.DTO.HomeDTO;
import com.example.cloneyoutubemusic.R;
import com.example.cloneyoutubemusic.databinding.ActivityMainBinding;
import com.example.cloneyoutubemusic.databinding.ActivityMusicBinding;

public class MusicActivity extends AppCompatActivity {
    ActivityMusicBinding binding;
    HomeDTO dto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMusicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dto = (HomeDTO) getIntent().getSerializableExtra("dto");

        binding.imgvTitle.setImageResource(dto.getMusic());


    }
}