package com.namastenepal.namastenepal.namastenepal.MainActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.namastenepal.namastenepal.namastenepal.Camera.CameraActivity;
import com.namastenepal.namastenepal.namastenepal.ImageFilter.ImageFilter;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.ChautariFragment.ChautariFragment;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.Profile.Profile;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment.SamajFragment;
import com.namastenepal.namastenepal.namastenepal.MyProfile.MyProfileActivity;
import com.namastenepal.namastenepal.namastenepal.PostActivity.Post_Activity;
import com.namastenepal.namastenepal.namastenepal.R;

public class MainActivity extends AppCompatActivity {

    private FrameLayout vFragmentHolder;
    BottomNavigationView navigation;
    private Toolbar vToolbar_main;
    private FirebaseAnalytics mFirebaseAnalytics;
    private FloatingActionButton floatingButton_V;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentManager managerr = getSupportFragmentManager();
                    FragmentTransaction transactionn = managerr.beginTransaction();
                    transactionn.replace(R.id.fragment_holder_main, new ChautariFragment());
                    transactionn.commit();
                    return true;
                case R.id.navigation_dashboard:
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.fragment_holder_main, new SamajFragment());
                    transaction.commit();
                    return true;
                case R.id.navigation_notifications:
                    Intent intent = new Intent(MainActivity.this, ImageFilter.class);
                    startActivity(intent);
                    return true;
                case R.id.profile:
                    FragmentManager ProfileManager = getSupportFragmentManager();
                    FragmentTransaction ProfileTransaction = ProfileManager.beginTransaction();
                    ProfileTransaction.replace(R.id.fragment_holder_main, new Profile());
                    ProfileTransaction.commit();
                    return true;
                case R.id.navigation_message:
                    Intent intent1 = new Intent(MainActivity.this, CameraActivity.class);
                    startActivity(intent1);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        permission();
        initComponent();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        floatingButton_V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Post_Activity.class);
                startActivity(intent);
            }
        });
        FragmentManager managerr = getSupportFragmentManager();
        FragmentTransaction transactionn = managerr.beginTransaction();
        transactionn.replace(R.id.fragment_holder_main, new ChautariFragment());
        transactionn.commit();
//        setSupportActionBar(vToolbar_main);
//        getSupportActionBar().setLogo(R.mipmap.logo_icon_only_png);
    }

    public void initComponent() {
        vFragmentHolder = findViewById(R.id.fragment_holder_main);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        floatingButton_V = findViewById(R.id.post);
        //  vToolbar_main = findViewById(R.id.toolbar_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public void permission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }
    }
}
