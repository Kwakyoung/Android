package com.example.and09_fragmentadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.and09_fragmentadapter.melon.MelonFragment;

public class MainActivity extends AppCompatActivity {

    Button btn_menu1, btn_menu2, btn_adapter;
    FrameLayout container_fl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Fragment를 붙이기 위한 공간, Fragment, FragmentManager 3가지의 요소가 필요하다.


        btn_menu1 = findViewById(R.id.btn_menu1);
        btn_menu2 = findViewById(R.id.btn_menu2);
        btn_adapter = findViewById(R.id.btn_adapter);
        // container_fl = findViewById(R.id.container_fl); <= FragmentManager에서는 객체로 초기화된 위젯이 필요x , 디자인 파일에 있는 id만 명시해주면 됨

        FragmentManager manager = getSupportFragmentManager(); // 프래그먼트 매니저의 초기화식!   new(x)   get 으로 받아옴
        btn_menu1.setOnClickListener(v -> {
            Log.d("KYG", "onCreate: 메뉴1");
            // 트랜잭션 : Oracle 작업 최소 단위    세트 : Commit & Rollback
            //manager.beginTransaction().add(R.id.container_fl, new HomeFragment(), "A").commit();
            manager.beginTransaction().replace(R.id.container_fl, new HomeFragment()).commit();
        });
        btn_menu2.setOnClickListener(v -> {
            Log.d("KYG", "onCreate: 메뉴2");
            // SubFragment를 하나 추가 후 (디자인 구분을 할수있게 배경색을 바꿔줌 )
            // FragmentManger를 이용해서 replace처리해보기.
            manager.beginTransaction().replace(R.id.container_fl, new SubFragment()).commit();

            //manager.beginTransaction().remove()
        });




        btn_adapter.setOnClickListener(v -> {
            Intent intent = new Intent(this, AdapterActivity.class);
            startActivity(intent);
        });


    }
}