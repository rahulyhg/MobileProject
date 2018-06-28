package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment.SamajService;

import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment.SamajDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SamajApi {
    @GET("community/api/community-list")
    Call<List<SamajDto>> getSamajDetail();
}
