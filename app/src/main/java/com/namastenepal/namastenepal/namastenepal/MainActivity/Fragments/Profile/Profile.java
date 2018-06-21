package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.ChautariFragment;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.FriendPosts.FriendPosts;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.MyPosts.MyPosts;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment.SamajFragment;
import com.namastenepal.namastenepal.namastenepal.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;


public class Profile extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_profile, container, false);
        initComponent(view);
        return view;
    }

    void initComponent(View view) {
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(), FragmentPagerItems.with(getContext())
                .add(R.string.my_post, MyPosts.class)
                .add(R.string.friend_post, FriendPosts.class)
                .create());
        ViewPager viewPager = view.findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = view.findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);
    }


}
