package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.namastenepal.namastenepal.namastenepal.ApiClient.ApiClient;
import com.namastenepal.namastenepal.namastenepal.Camera.CameraActivity;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.Adapter.ChautariAdapter;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.ChautraiDto.ChautariDto;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.Service.ChautariApi;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment.SamajAdapter;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment.SamajDto;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment.SamajService.SamajApi;
import com.namastenepal.namastenepal.namastenepal.News.DiscussedNews;
import com.namastenepal.namastenepal.namastenepal.News.HotNews;
import com.namastenepal.namastenepal.namastenepal.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChautariFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    ImageView vCamera_Share_ImageView;
    TextView vCamera_Share_TextView;
    ChautariApi chautariApi;
    private SwipeRefreshLayout vSwipeRefresh;
    private List<ChautariDto> chautariDtos;
    private ChautariAdapter IcChautariAdapter;
    private RecyclerView vRecylerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chautari, container, false);
        initComponent(view);
        vCamera_Share_TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CameraActivity.class);
                startActivity(intent);
            }
        });
        vCamera_Share_ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CameraActivity.class);
                startActivity(intent);
            }
        });
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
        vCamera_Share_ImageView = view.findViewById(R.id.camera_share);
        vCamera_Share_TextView = view.findViewById(R.id.camera_share_text);
        vSwipeRefresh = view.findViewById(R.id.swipeRefresh_chautari);
        vRecylerView = view.findViewById(R.id.recyclerView_Chautari);
    }

    public void fetchInformation() {
        vSwipeRefresh.setRefreshing(true);
        chautariApi = ApiClient.getApiClient().create(ChautariApi.class);
        Call<List<ChautariDto>> call = chautariApi.getChautraiDetail();
        call.enqueue(new Callback<List<ChautariDto>>() {
            @Override
            public void onResponse(Call<List<ChautariDto>> call, Response<List<ChautariDto>> response) {
                chautariDtos = response.body();
                IcChautariAdapter = new ChautariAdapter(chautariDtos, getContext());
                vRecylerView.setAdapter(IcChautariAdapter);
                vSwipeRefresh.setRefreshing(false);
                Toast.makeText(getContext(), "Suceed", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<ChautariDto>> call, Throwable t) {
                vSwipeRefresh.setRefreshing(true);
                Toast.makeText(getContext(), "" + t, Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onRefresh() {
        fetchInformation();
    }
}
