package com.example.exam00;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    // getSum이라는 메소드 만들기. ( 숫자 두개(아무거나)를 입력받아서 두 수의 합을 구하는 메소드이다 )

    TextView tv1 ;
    Button btn1, btn_start, btn_stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 메소드를 호출하고 안드로이드 기기를 실행해보기.
//            getSum(1,2); // 메소드가 구현(정의) 되어있는 파라메터부 = 호출부의 파라메터 값을 합치면 변수 초기화식이 된다.
            // int i = 1 , int j = 2
        tv1 = findViewById(R.id.tv1);
        btn1 = findViewById(R.id.btn1);
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);


        btn_start.setOnClickListener(new KygOneClick());
        KygCallback callback = new KygCallback() {
            @Override
            public void onResponse(String data) {

            }

            @Override
            public void onFailure(String data) {

            }
        };

        ClacDAO dao = new ClacDAO();

//        dao.getSum(1,2,btn1);
//        dao.getSum(1,2,tv1);
//        tv1.setText(dao.getSum(1,2)+"");
//        btn1.setText(dao.getSum(1,2)+"");

    }

    // 메소드는 구현이 자유롭다.
    // 실행은 항상 사용하는 곳에서 호출을 해줘야지만 됨.
//    public void getSum(int i, int j){
//        Log.d("두수의 합", "getSum: "+(i+j));
//        tv1.setText(i+j+"");
//
//    }


    public class KygOneClick implements View.OnClickListener { // 다형성에 의해서 View.OnClickListener는 onClic이라는 메소드가 반드시 구현되어야 하는 규칙이 있다.
                                                               // 인터페이스 상속을 받게되면 onClick이라는 메소드가 반드시 구현되기 때문에 둘은 같다라는 규칙이 성립됨.

        // 하나가 만들어짐. 추상메소드.
        @Override
        public void onClick(View v) {
            Log.d("온클릭", "onClick: ");
        }
    }

    public interface KygCallback {
        public void onResponse(String data);
        public void onFailure(String data);
    }

}