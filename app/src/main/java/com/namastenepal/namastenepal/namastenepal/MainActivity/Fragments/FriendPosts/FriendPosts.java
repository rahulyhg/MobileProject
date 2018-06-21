package com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.FriendPosts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.namastenepal.namastenepal.namastenepal.R;

public class FriendPosts extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friend_posts_fragment, container, false);
        return view;
    }
}
