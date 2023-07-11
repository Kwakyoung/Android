package com.example.cloneyoutubemusic.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cloneyoutubemusic.Home.DTO.HomeDTO;
import com.example.cloneyoutubemusic.R;
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



        binding.imgvTitle.setImageResource(dto.getMusic1());
        binding.tvTitle.setText(dto.getTitle1());
        binding.tvSinger.setText(dto.getSinger1());

        binding.imgvTitle.setImageResource(dto.getMusic2());
        binding.tvTitle.setText(dto.getTitle2());
        binding.tvSinger.setText(dto.getSinger2());

        binding.btnPlay.setOnClickListener(v -> {
            binding.btnPlay.setImageResource(R.drawable.pause_24);

        });

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });






//        if ( dto == (HomeDTO) getIntent().getSerializableExtra("dto") ) {
//            binding.imgvTitle.setImageResource(dto.getMusic1());
//            binding.tvTitle.setText(dto.getTitle1());
//            binding.tvSinger.setText(dto.getSinger1());
//        }
//        } else if (dto == (HomeDTO) getIntent().getSerializableExtra("dto1")) {
//            binding.imgvTitle.setImageResource(dto.getMusic2());
//            binding.tvTitle.setText(dto.getTitle2());
//            binding.tvSinger.setText(dto.getSinger2());
//        }


    }
}