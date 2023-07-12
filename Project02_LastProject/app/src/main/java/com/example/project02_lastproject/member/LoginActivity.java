package com.example.project02_lastproject.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.project02_lastproject.MainActivity;
import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.CommonConn;
import com.example.project02_lastproject.common.CommonVar;
import com.example.project02_lastproject.databinding.ActivityLoginBinding;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v -> {
            if(binding.edtId.getText().toString().length() < 1
              || binding.edtPw.getText().toString().length() < 1){
                Toast.makeText(this, "아이디 또는 패스워드를 입력하세요.", Toast.LENGTH_SHORT).show();
                return;
            }

            CommonConn conn = new CommonConn(this , "member/login");
            conn.addParamMap("id",binding.edtId.getText().toString());
            conn.addParamMap("password",binding.edtPw.getText().toString());
            conn.onExcute(((isResult, data) -> {
                if(isResult){
                    CommonVar.loginInfo = new Gson().fromJson(data , MemberVO.class);    // CommonVar.loginInfo <=  MemberVO vo 를 CommonVar 에서 스태틱으로 담아둠 그래서 이렇게 사용.
                    if(CommonVar.loginInfo==null){                                       // CommonVar.loginInfo = vo;
                        Toast.makeText(this, "아이디 또는 비밀번호를 확인", Toast.LENGTH_SHORT).show();
                    }else{
                        // CommonVar.loginInfo = vo;
                        Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                        startActivity(intent);
                    }
                }
            }));
        });



    }
}