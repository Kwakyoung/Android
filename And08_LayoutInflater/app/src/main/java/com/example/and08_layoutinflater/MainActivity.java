package com.example.and08_layoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LayoutInflater inflater; // <=  인플레이션 과정의 작업을 해주는 객체 ( 레이아웃인플레이터 : 메모리에 디자인 파일을 올려줌 )
    LinearLayout container_ln;
    FrameLayout container_fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // <= 내부적으로는 inflater객체가 이미 인플레이션 과정을 자동으로 해줌.

        // 액티비티 기준
        inflater = getLayoutInflater(); // 초기화 완료
        // inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        container_ln = findViewById(R.id.container_ln);
        container_fl = findViewById(R.id.container_fl);

        View vLinear = inflater.inflate(R.layout.sub_layout1, container_ln, true); // 1. 지금바로 붙이겠음   2. 내 리소스를 현재 화면에 리소스에 붙일껀지.
        View vFrame  = inflater.inflate(R.layout.sub_layout2, container_fl, true); // 2. 지금바로 붙이겠음   2. 메모리를 같이 쓸껀지.
        // attactToRoot를 true로 쓰는 경우는 지금이 마지막이다. (false)사용하기때문
        // 이유는 코드부를 별도로 가지고있는 즉 액티비티와 유사하게 디자인파일 하나(xml) 코드파일 하나(java)를 별도로 가지고 붙이는 처리를 알아서하는
        // "Fragment"라는 것을 쓰기때문임.
        Button btn_sub1 = vLinear.findViewById(R.id.sub1);   // 두개의 방식 다 가능
        Button btn_sub2 = vFrame.findViewById(R.id.sub2);    // 두개의 방식 다 가능

        btn_sub1.setOnClickListener(v -> {
            Toast.makeText(this, "서브1에 있는 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
        });

        btn_sub2.setOnClickListener(v -> {
            Toast.makeText(this, "서브2에 있는 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
        });
    }
}