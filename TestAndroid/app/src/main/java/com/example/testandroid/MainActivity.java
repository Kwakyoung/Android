package com.example.testandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CustomDialog dialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);




        dialog = new CustomDialog(this,size);
        dialog.show();
        findViewById(R.id.rl_layout).setOnClickListener(v->{
            if(dialog.isShowing()){
                dialog.dismiss();
            }else{
                dialog.show();
            }

        });


        //start



//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mp.pause();
//            }
//        });


    }





    public class CustomDialog extends Dialog{
        MediaPlayer player ;
        SeekBar sb_mp3;
        ImageView imgv_play;
        TextView tvTime ;
        FrameLayout frm_layout ;
        public CustomDialog(@NonNull Context context, Point size) {
            super(context);
            setContentView(R.layout.dialog_call);
            this.getWindow().setLayout(size.x , size.y);
            tvTime = findViewById(R.id.tvTime);
            sb_mp3 = findViewById(R.id.sb_mp3);
            player = MediaPlayer.create(context , R.raw.sample);
            imgv_play = findViewById(R.id.imgv_play);
            frm_layout = findViewById(R.id.frm_layout);
            sb_mp3.setVisibility(ProgressBar.VISIBLE);
            sb_mp3.setMax(player.getDuration());

            frm_layout.setOnClickListener(v->{
                if(isShowing()){
                    dismiss();
                }else{
                    show();
                }
            });


            sb_mp3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if(fromUser) {
                        player.seekTo(progress);
                    }
                    int m = progress / 60000;
                    int s = (progress % 60000) / 1000;
                    String strTime = String.format("%02d:%02d", m, s);
                    tvTime.setText(strTime);
                }
                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }
                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });

            player.start();
            mp3Thread();


            imgv_play.setOnClickListener(v->{
                if(player.isPlaying()){
                    player.pause();
                    imgv_play.setImageResource(R.drawable.baseline_pause_24);
                }else{
                    player.start();
                    imgv_play.setImageResource(R.drawable.baseline_play_arrow_24);
                }
                mp3Thread();

            });


        }

        public void mp3Thread(){
            Runnable task = new Runnable(){
                public void run(){
                    while(player.isPlaying()){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        sb_mp3.setProgress(player.getCurrentPosition());
                    }
                }
            };
            Thread thread = new Thread(task);
            thread.start();
        }
    }


}