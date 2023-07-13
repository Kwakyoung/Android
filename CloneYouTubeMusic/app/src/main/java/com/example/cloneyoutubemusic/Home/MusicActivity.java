package com.example.cloneyoutubemusic.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.SeekBar;

import com.example.cloneyoutubemusic.Home.DTO.HomeDTO;
import com.example.cloneyoutubemusic.R;
import com.example.cloneyoutubemusic.databinding.ActivityMusicBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MusicActivity extends AppCompatActivity {
    ActivityMusicBinding binding;
    HomeDTO dto;

    private SeekBar seekBar;
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMusicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        seekBar = findViewById(R.id.seekbar);

        dto = (HomeDTO) getIntent().getSerializableExtra("dto");


        binding.imgvTitle.setImageResource(dto.getMusic1());
        binding.tvTitle.setText(dto.getTitle1());
        binding.tvSinger.setText(dto.getSinger1());

        binding.imgvTitle.setImageResource(dto.getMusic2());
        binding.tvTitle.setText(dto.getTitle2());
        binding.tvSinger.setText(dto.getSinger2());

        binding.btnPlay.setOnClickListener(v -> {
            binding.btnPlay.setImageResource(R.drawable.pause_24);
            if (isPlaying){
                isPlaying = false;
            } else {
                isPlaying = true;
                startPlayback();
            }

        });

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

    }


    public void startPlayback(){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            int progress = 0;
            @Override
            public void run() {
                if (isPlaying && progress < seekBar.getMax()){
                    progress++;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            seekBar.setProgress(progress);
                        }
                    });
                }else {
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask, 0 , 1000); // 1초마다 실행
    }



}