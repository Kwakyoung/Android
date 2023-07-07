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
            conn.onExcute(new CommonConn.KygCallBack() {
                @Override
                public void onResult(boolean isResult, String data) {
                    // 결과 받아오기 ..
                }
            }); // onExcute 메소드가 실행되면 일단 Spring으로 전송처리는 정상적으로 작동한다. ( 결과를 가져오려면 어떻게 해야할까? )

        });

    }


}