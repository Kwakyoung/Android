package com.example.and00_login;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface RetrofitInterface {

    @GET("member/{mapping}")
    Call<String> getMethod(@Path("mapping") String mapping , @QueryMap HashMap<String , Object> paramMap);

    @FormUrlEncoded  // Url을 받아오는 처리를 함 ↓ @Url ...
    @POST
    Call<String> PostMethod(@Url String url , @FieldMap HashMap<String , Object> paramMap);
}
