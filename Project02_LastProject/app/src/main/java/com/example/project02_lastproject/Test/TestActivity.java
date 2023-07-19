package com.example.project02_lastproject.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.RetrofitClient;
import com.example.project02_lastproject.common.RetrofitInterface;
import com.example.project02_lastproject.databinding.ActivityTestBinding;

import java.util.HashMap;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {
    ActivityTestBinding binding;
//    CallbackKyg callback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        callback = new CallbackKyg() {
//            @Override
//            public void onResult(String data) {
//                binding.tvResult.setText("응답 : "+data);  // 이렇게 메소드로 해놓고하면 일괄적으로 응답 : 을 붙일수있음. 일일이 안써줘도 됨! 그래서 일을 덜할수있음
//            }
//        };



        binding.btnSelect.setOnClickListener(v -> {
            // RetrofitClient : 접속 방법, 컨버터 등 통신에 대한 전반적인 방법이 있는 객체.
            // RetrofitInterface : 접속 후 데이터 전송 방식, 파라메터 타입 등등의 기능에 가까운 객체.
            commonExcute(binding.edtUrl.getText().toString(), new HashMap<>(), new CallbackKyg() {
                @Override
                public void onResult(String data) {
                    binding.tvResult.setText(data);
                }
            });
//            RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
//            api.PostMethod(binding.edtUrl.getText().toString(), new HashMap<>()).enqueue(new Callback<String>() {
//                @Override
//                public void onResponse(Call<String> call, Response<String> response) {
////                    binding.tvResult.setText(response.body()); 이걸 묶어주면
//                    callback.onResult( response.body() );
//
//                }
//
//                @Override
//                public void onFailure(Call<String> call, Throwable t) {
//                    binding.tvResult.setText(t.getMessage());
//                }
//            });
        });


        binding.btnInsert.setOnClickListener(v -> {
            HashMap<String, Object> params = new HashMap<>();
            params.put("col1", "random값1"+new Random().nextInt(100));
            params.put("col2", "random값2"+new Random().nextInt(100));

            // 3번
            commonExcute("insert.re", params, data -> {
                binding.tvResult.setText("INSERT의 결과 1은 성공 : "+ data);
            });
//            api.PostMethod("insert.re",params).enqueue(new Callback<String>() {
//                @Override
//                public void onResponse(Call<String> call, Response<String> response) {
//                    binding.tvResult.setText(response.body());
//                }
//
//                @Override
//                public void onFailure(Call<String> call, Throwable t) {
//
//                }
//            });
        });


        binding.btnUpdate.setOnClickListener(v -> {

//            method(new CallbackKyg() {
//                @Override
//                public void onResult(String data) {
//                    Log.d("로그", "onResult: 여기가 실행됨. <- 찍히게 하려면 어떻게 해야할까?");
//
//                }
//            });
//            method(new KygVO());

        });
    }
//    public void method(KygVO vo){
//        vo.method();
//    }
//
//    public class KygVO{
//        public void method(){
//            Log.d("로그", "onResult: 여기가 실행됨. <- 찍히게 하려면 어떻게 해야할까?");
//
//        }
//    }



    // 2번
    public void commonExcute(String url, HashMap<String, Object> map, CallbackKyg callback) {
        RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
        api.PostMethod(url , map).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }


    // 1번
    public interface CallbackKyg{
        public void onResult(String data);



    }

}