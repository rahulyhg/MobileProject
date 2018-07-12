package com.namastenepal.namastenepal.namastenepal.MainActivity.SamajActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.FriendPosts.FriendPosts;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.MyPosts.MyPosts;
import com.namastenepal.namastenepal.namastenepal.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import de.hdodenhof.circleimageview.CircleImageView;

public class Samaj_Activity extends AppCompatActivity {
    private TextView vSamaj_name_samaj;
    private TextView vSamaj_description_samaj;
    private CircleImageView vCircleImageView_Samaj;
    private Bitmap profileBitmap;
    String Vsamaj_name;
    String Vsamaj_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samaj);
        Intent intent = getIntent();
        profileBitmap = intent.getParcelableExtra("profile");
        Vsamaj_name = intent.getStringExtra("name");
        Vsamaj_description = intent.getStringExtra("description");
        initComponent();
        vCircleImageView_Samaj.setImageBitmap(profileBitmap);
        vSamaj_name_samaj.setText(Vsamaj_name);
        vSamaj_description_samaj.setText(Vsamaj_description);
    }

    public void initComponent() {
//        vCircleImageView_Samaj=findViewById(R.id.samaj_profile_image);
//        vSamaj_name_samaj = findViewById(R.id.samaj_name_activity);
//        vSamaj_description_samaj = findViewById(R.id.samaj_description_activity);
//        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), FragmentPagerItems.with(getApplicationContext())
//                .add(R.string.my_post, MyPosts.class)
//                .add(R.string.friend_post, FriendPosts.class)
//                .create()
//        );
//        ViewPager viewPager = findViewById(R.id.viewpager_samaj);
//        viewPager.setAdapter(adapter);
//        SmartTabLayout viewPagerTab = findViewById(R.id.viewpagertab_samaj);
//        viewPagerTab.setViewPager(viewPager);
    }
}
