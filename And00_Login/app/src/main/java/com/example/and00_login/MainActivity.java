package com.example.and00_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    // 메소드 => 리턴타입이 있는 메소드를 구현, 호출을 자유롭게 하고 사용하는 이유를 명확히 알고있다.
    // 클래스 => 클래스 내부에 있는 멤버의 접근과 각각 멤버를 구분하고 자유롭게 커스텀할수있다. (변형)
    // 인터페이스 => 인터페이스의 규칙을 명확히 알고 자유롭게 구현하여 사용할 수 있다.

    // interface


    // editext사용자가 어떤걸 입력함. 입력을 마치고, 로그인 버튼을 누름=> 전송
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edt_id, edt_pw;
        Button btn ;

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        btn = findViewById(R.id.btn);






        CommonConn.KygCallBack callback = new CommonConn.KygCallBack() {
            @Override
            public void onResult(boolean isResult, String data) {
                // 결과 받아오기 ..
                Log.d("결과", "onResult: " + data);
            }
        };      // 이 메소드. 원래 아래있던걸 짤라서 여기로 써놓음.
        Log.d("콜백", "onCreate: " + callback);



        btn.setOnClickListener(v -> {
            // 매번 이렇게 하기보단 Common(공통)에 저장하여 밑에 코드로 간단하게 처리하기. (협업시에도 편함)
//            RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);  // 초기화식
//            HashMap<String , Object> paramMap = new HashMap<>();
//            paramMap.put("id", edt_id.getText().toString());
//            paramMap.put("pw", edt_pw.getText().toString());
//
//            api.getMethod("login", paramMap).enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Log.d("래트로핏", "onResponse: "+response.body());
//            }
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.d("래트로핏", "onResponse:11 "+t.getMessage());
//            }
//        });

            CommonConn conn = new CommonConn(this , "member/login");
            conn.addParamMap("id", edt_id.getText().toString());
            conn.addParamMap("pw", edt_pw.getText().toString());
            conn.onExcute(callback); // onExcute 메소드가 실행되면 일단 Spring으로 전송처리는 정상적으로 작동한다. ( 결과를 가져오려면 어떻게 해야할까? )

        });

        TestVO vo = new TestVO();
        vo.str="111";
        testMethod(vo);
        Log.d("aaa", "onCreate: "+ vo.str);

        callback.onResult(true,"값을 넘김");  // 외부에서 이코드를 쓸수있게 해줌.
    }

    public class TestVO {
        String str;
    }
    public void testMethod(TestVO vo){
        vo.str="222";
    }

}