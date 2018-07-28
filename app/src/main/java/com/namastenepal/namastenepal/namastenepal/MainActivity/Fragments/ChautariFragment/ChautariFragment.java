package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.crash.FirebaseCrash;
import com.namastenepal.namastenepal.namastenepal.ApiClient.ApiClient;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.Adapter.ChautariAdapter;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.ChautraiDto.ChautariDto;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.Service.ChautariApi;
import com.namastenepal.namastenepal.namastenepal.PostActivity.Post_Activity;
import com.namastenepal.namastenepal.namastenepal.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChautariFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    ChautariApi chautariApi;
    private SwipeRefreshLayout vSwipeRefresh;
    private ChautariAdapter IcChautariAdapter;
    RecyclerView vRecylerView;
    private List<ChautariDto> chautariDtoList;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView post;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chautari, container, false);
        initComponent(view);

        vSwipeRefresh.setOnRefreshListener(this);
        vSwipeRefresh.post(new Runnable() {
            @Override
            public void run() {
                vSwipeRefresh.setRefreshing(true);
                fetchInformation();
            }
        });
        return view;
    }

    public void initComponent(View view) {
        vRecylerView = view.findViewById(R.id.recyclerView_Chautari);
        layoutManager = new LinearLayoutManager(getContext());
        vRecylerView.setLayoutManager(layoutManager);
        vRecylerView.setHasFixedSize(true);
        vSwipeRefresh = view.findViewById(R.id.swipeRefresh_chautari);
//        FirebaseCrash.log("Activity created");

    }

    public void fetchInformation() {
        vSwipeRefresh.setRefreshing(true);
        chautariApi = ApiClient.getApiClient().create(ChautariApi.class);
        Call<List<ChautariDto>> call = chautariApi.getChautariDetail("timestamp");
        call.enqueue(new Callback<List<ChautariDto>>() {
            @Override
            public void onResponse(Call<List<ChautariDto>> call, Response<List<ChautariDto>> response) {
                chautariDtoList = response.body();
                IcChautariAdapter = new ChautariAdapter(chautariDtoList, getContext());
                vRecylerView.setAdapter(IcChautariAdapter);
                vSwipeRefresh.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<ChautariDto>> call, Throwable t) {
                vSwipeRefresh.setRefreshing(true);
            }
        });
    }

    @Override
    public void onRefresh() {
        fetchInformation();
    }
}
