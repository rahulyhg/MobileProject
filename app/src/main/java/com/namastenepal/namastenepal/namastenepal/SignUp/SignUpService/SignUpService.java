package com.namastenepal.namastenepal.namastenepal.SignUp.SignUpService;

import com.namastenepal.namastenepal.namastenepal.SignUp.SignUpDto.SignUpDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignUpService {
    @POST("/api/rest-auth/registration/")
    Call<SignUpDto> signUp(@Body SignUpDto signUpDto);
}
