package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment;


import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.RecyclerView;


import com.namastenepal.namastenepal.namastenepal.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

import static android.content.ContentValues.TAG;


public class SamajFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private List<SamajDto> SamajDtoArrayList;
    RecyclerView vRecyclerView;
    private SamajAdapter IcSamajAdapter;
    SamajApi samajApi;
    private RecyclerView.LayoutManager layoutManager;
    SwipeRefreshLayout vSwipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_samaj, container, false);
        initComponent(view);
        vSwipeRefreshLayout.setOnRefreshListener(this);
        vSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                vSwipeRefreshLayout.setRefreshing(true);
                fetchInformation();
            }
        });
        return view;
    }

    public void initComponent(View view) {
        vRecyclerView = view.findViewById(R.id.recyclerView_samaj);
        layoutManager = new LinearLayoutManager(getContext());
        vRecyclerView.setLayoutManager(layoutManager);
        vRecyclerView.setHasFixedSize(true);
        vSwipeRefreshLayout = view.findViewById(R.id.swipeRefresh);
    }

    public void fetchInformation() {
        vSwipeRefreshLayout.setRefreshing(true);
        samajApi = ApiClient.getApiClient().create(SamajApi.class);
        Call<List<SamajDto>> call = samajApi.getSamajDetail();
        call.enqueue(new Callback<List<SamajDto>>() {
            @Override
            public void onResponse(Call<List<SamajDto>> call, retrofit2.Response<List<SamajDto>> response) {
                SamajDtoArrayList = response.body();
                IcSamajAdapter = new SamajAdapter(SamajDtoArrayList, getContext());
                vRecyclerView.setAdapter(IcSamajAdapter);
                vSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<SamajDto>> call, Throwable t) {
                vSwipeRefreshLayout.setRefreshing(true);
                Toast.makeText(getContext(), "" + t, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onRefresh() {
        fetchInformation();
    }
}
