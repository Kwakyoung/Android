package com.example.cloneyoutubemusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.Toast;

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

    private boolean like = false;
    private Handler handler;
    private Runnable runnable;
    private int progress = 0 ; // 시크바의 진행 위치 저장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMusicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        seekBar = findViewById(R.id.seekbar);
        handler = new Handler();

        dto = (HomeDTO) getIntent().getSerializableExtra("dto");


        binding.imgvTitle.setImageResource(dto.getMusic1());
        binding.tvTitle.setText(dto.getTitle1());
        binding.tvSinger.setText(dto.getSinger1());

//        binding.imgvTitle.setImageResource(dto.getMusic2());
//        binding.tvTitle.setText(dto.getTitle2());
//        binding.tvSinger.setText(dto.getSinger2());
        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

        binding.imgvLike.setOnClickListener(v -> {
            if(like){
                dto.setLike(R.drawable.thumb_up_24);
                binding.imgvLike.setImageResource(dto.getLike());
                Toast.makeText(this, "좋아요 표시한 컨텐츠에서 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                like = false;
            }else {
                dto.setLike(R.drawable.thumb_up_alt_24);
                binding.imgvLike.setImageResource(dto.getLike());
                Toast.makeText(this, "좋아요 표시한 노래에 추가되었습니다.", Toast.LENGTH_SHORT).show();
                like = true;
            }
        });


        binding.btnPlay.setOnClickListener(v -> {
            if (isPlaying){
                isPlaying = false;
                handler.removeCallbacks(runnable);
                binding.btnPlay.setImageResource(R.drawable.baseline_play_arrow_24);
            } else {
                binding.btnPlay.setImageResource(R.drawable.pause_24);
                isPlaying = true;
                startPlayback();
            }

        });

    }



    private void startPlayback() {

        if(progress == seekBar.getMax()){

            binding.imgvTitle.setImageResource(dto.getMusic2());
            binding.tvTitle.setText(dto.getTitle2());
            binding.tvSinger.setText(dto.getSinger2());
            progress = 0;
        }

        seekBar.setProgress(progress);

        // 1초마다 SeekBar를 업데이트하는 Runnable 실행
        runnable = new Runnable() {
            @Override
            public void run() {
                if (seekBar.getProgress() < seekBar.getMax()) {
                    seekBar.setProgress(seekBar.getProgress() + 1);
                    progress = seekBar.getProgress();
                    handler.postDelayed(this, 1000);
                    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                            progress = seekBar.getProgress(); // progress에 시크바 진행상황 저장.
                        }
                    });

                } else {
                    // SeekBar가 최대값에 도달하면 재생 중지
                    isPlaying = false;
                }
            }
        };

        handler.postDelayed(runnable, 1000);
    }




//    public void startPlayback(){
//        Timer timer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            int progress = 0;
//            @Override
//            public void run() {
//                if (isPlaying && progress < seekBar.getMax()){
//                    progress++;
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            seekBar.setProgress(progress);
//                        }
//                    });
//                }else {
//                    timer.cancel();
//                }
//            }
//        };
//        timer.schedule(timerTask, 0 , 1000); // 1초마다 실행
//    }



}