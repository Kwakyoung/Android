package com.example.cloneyoutubemusic.search;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.cloneyoutubemusic.R;
import com.example.cloneyoutubemusic.databinding.ActivitySearchBinding;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ActivitySearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

        binding.recvHistory.setLayoutManager(new LinearLayoutManager(getBaseContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recvHistory.setAdapter(new SearchAdapter(getBaseContext(),getlist()));

        binding.edt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    // 엔터 키가 눌렸을 때 클릭 이벤트를 처리
                    v.performClick();
                    binding.tvTest.setText(binding.edt.getText().toString());
                    return true;
                }
                return false;
            }
        });

    }


    ArrayList<SearchVO> getlist(){
        ArrayList<SearchVO> list = new ArrayList<>();
        list.add(new SearchVO(R.drawable.newjeans_supershy,"Super Shy","New Jeans"));
        list.add(new SearchVO(R.drawable.lucy,"히어로","루시"));
        list.add(new SearchVO(R.drawable.quick_stray,"이름엄청긴거입니다아아아아아아아","ㅋㅋ"));

        return list;
    }
}