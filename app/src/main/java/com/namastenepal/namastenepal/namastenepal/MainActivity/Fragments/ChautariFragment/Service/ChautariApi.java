package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.Service;

import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.ChautraiDto.ChautariDto;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.ChautraiDto.ChautariDtoResponse;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment.SamajDto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ChautariApi {
    @GET("community/api/community-posts/sort-by={type}/")
        //   Call<ChautariDtoResponse> getChautraiDetail(@Path("type") String type);
    Call<List<ChautariDto>> getChautariDetail(@Path("type") String type);
}
