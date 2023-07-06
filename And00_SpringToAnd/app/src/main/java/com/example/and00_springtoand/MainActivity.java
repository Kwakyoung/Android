package com.example.and00_springtoand;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ApiInterface가 초기화 되어야함.
        // 초기화 식 : ApiInterface name = Retrofit.create( ApiInterface.class );

//        HashMap<Integer , String> map = new HashMap<>();
//        map.put(1,"곽영균");

        RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);  // 초기화식
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("param", "값 안드");
        paramMap.put("param", "값 안드1");
        paramMap.put("param", "값 안드2");   // K(KEY) 값이 같으면 맨 마지막거만 실행됨. -> 그러니 중복되면 안됀다!
        // CallBack : 희미하게 KakaoLogin
        // JSP 카카오 로그인 버튼 누름 -> Controller -> REST API ( 카카오 서버에 특정 맵핑을 호출하고 , 파라메터를 넘겨줌. (Client_id) )
        // -> 사용자가 카카오 로그인을 함. (언제끝남? 모름.) 끝나면 내가 만들어 둔 나의 Controller로 데이터를 주라. -> Callback
        //  Callback은 입력이 끝날시 데이터를 주라.


        // Dialog처리 : 사용자는 기다리는 일을 잘 못함. (==> 아무런 디자인 처리 없이 )
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("레트로핏");
        dialog.setMessage("데이터를 가져오는 중...");
        dialog.setProgress(ProgressDialog.STYLE_SPINNER); // 삥글삥글 돌기
        dialog.setCancelable(false);  // 터치 못하게 하기.
        dialog.show(); // 보여주기



        api.clientPostMethod("list.cu", paramMap).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("래트로핏", "onResponse: 응답이 왔음. Spring에서 이후 처리 진행" + response.body());
                dialog.dismiss(); // 다이아로그가 안보이게 처리
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("래트로핏", "onFailure: url , 포트 , Spring 응답업음 등의 이유로 실패");
            }
        });




        // 위에껀 쉽게 반복사용하기위함. 위에께 더 편함.
        // interface에서 list.cu 이동할곳을 지정해서 단일만 사용가능함
//        RetrofitClient rc = new RetrofitClient();
//        RetrofitInterface api = rc.getRetrofit().create(RetrofitInterface.class);
        // 여기까진 초기화식.

//        api.getCulist().enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Log.d("레트로핏", "onResponse: ");
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.d("레트로핏", "onResponse: ");
//            }
//        });

//        api.getCu().enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Log.d("레트로핏", "onResponse: ");
//                //String to Object(CustomerVO) 'Gson'
//                CustomerVO vo = new Gson().fromJson(response.body() , CustomerVO.class);
//                Log.d("레트로핏", "onResponse: "+vo);
//                Log.d("레트로핏", "onResponse: "+vo.getName());
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.d("레트로핏", "onFailure: ");
//            }
//        });
//
//        api.getCulist().enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                String result = response.body();
//                // TypeToken < 자동완성 버그가 있으니 아무데나 가서 TypeToken글자를 쳐줌. <- list형태로 바꿀때 사용함.
//                ArrayList<CustomerVO> list = new Gson().fromJson(
//                        result, new TypeToken<ArrayList<CustomerVO>>(){}.getType()
//                );
//                Log.d("레트로핏", "onResponse: "+ list.size());
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });
    }
}