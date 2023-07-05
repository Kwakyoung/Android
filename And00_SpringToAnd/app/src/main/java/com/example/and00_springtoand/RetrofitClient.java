package com.example.and00_springtoand;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {

    public Retrofit getRetrofit(){
        // baseUrl ( http://192.168.0.10/middle/  : Spring에서 프로젝트까지의 경로 ( Home )
            Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.0.10:8080/middle/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();

        return retrofit;

    }



//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("https://api.github.com/")
//            .build();
//
//    GitHubService service = retrofit.create(GitHubService.class);
}
