package com.namastenepal.namastenepal.namastenepal.Login.Service;

import retrofit2.Call;
import retrofit2.http.POST;

public interface LoginService {
    @POST("/api/rest-auth/login/")
    Call<User> basicLogin();
}
