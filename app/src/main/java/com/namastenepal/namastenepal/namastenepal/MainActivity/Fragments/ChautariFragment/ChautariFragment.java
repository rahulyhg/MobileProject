package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.namastenepal.namastenepal.namastenepal.Camera.CameraActivity;
import com.namastenepal.namastenepal.namastenepal.News.DiscussedNews;
import com.namastenepal.namastenepal.namastenepal.News.HotNews;
import com.namastenepal.namastenepal.namastenepal.R;

public class ChautariFragment extends Fragment {
    ImageView vCamera_Share_ImageView;
    TextView vCamera_Share_TextView;

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
        return view;
    }

    public void initComponent(View view) {
        vCamera_Share_ImageView = view.findViewById(R.id.camera_share);
        vCamera_Share_TextView = view.findViewById(R.id.camera_share_text);
    }

}
