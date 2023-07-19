package com.example.project02_lastproject.common;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface RetrofitInterface {



    @GET("{url}")
    Call<String> GetMethod(@Url String mapping , @QueryMap HashMap<String, Object> paramMap);

    @FormUrlEncoded
    @POST
    Call<String> PostMethod(@Url String url , @FieldMap HashMap<String, Object> paramMap);
}
