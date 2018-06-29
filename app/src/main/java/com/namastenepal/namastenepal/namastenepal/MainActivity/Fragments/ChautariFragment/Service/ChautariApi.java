package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.Service;

import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.ChautraiDto.ChautariDto;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment.SamajDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChautariApi {
    @GET("community/api/community-posts/sort-by")
    Call<List<ChautariDto>> getChautraiDetail();
}
