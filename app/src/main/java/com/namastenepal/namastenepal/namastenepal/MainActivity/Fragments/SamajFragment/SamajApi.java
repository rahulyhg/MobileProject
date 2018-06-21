package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SamajApi {
    @GET("community-list")
    Call<List<SamajDto>> getSamajDetail();
}
