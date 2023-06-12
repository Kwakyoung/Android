package com.example.and05_etclayoutscroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // static키워드가 있어서 초기화 과정 없이 사용 가능. KygClass.ATTR
        // static키워드가 없어서 초기화를 시켜야만 사용가능 .new KygClass().append("초기화해야지 사용가능");


        TextView tv_text = findViewById(R.id.tv_text); // 내가 레이아웃(activity_main)에 만든 위젯을 찾아서 java코드 변수로 초기화
        //TextView.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR // <= Static Member : 클래스가 인스턴스화 하지 않아도 메모리에 이미 올라가있는 자원
        //tv_text.append(); // <= Instence Member : 클래스가 인스턴스화 해야지만 메모리에 로딩되는 멤버

        Button btn_scroll = findViewById(R.id.btn_scroll);
        ScrollView scrollView = findViewById(R.id.scrollview);
        HorizontalScrollView horizon_scroll = findViewById(R.id.horizon_scroll);

        for (int i = 0; i < 50; i++) {
            tv_text.append("안녕하세요"+ i +"\n");
            for (int j = 0; j < 10; j++) {
                tv_text.append("안녕하세요"+ i );
            }
        }


        btn_scroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("스크롤 위치", "getScrollY" + scrollView.getScrollY());
                scrollView.scrollTo(0,scrollView.getScrollY()+100);
                horizon_scroll.smoothScrollTo(horizon_scroll.getScrollX()+100, 0);
            }
        });

    }


}