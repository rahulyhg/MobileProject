package com.namastenepal.namastenepal.namastenepal.Login.Service;

import com.namastenepal.namastenepal.namastenepal.Login.LoginDto.LoginDto;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface LoginService {
    @POST("/api/auth/login/")
    Call<LoginDto> Login(@Body LoginDto loginDto);

    @GET("token")
    Call<ResponseBody> getToken(@Header("Authorization") String authToken);
}
