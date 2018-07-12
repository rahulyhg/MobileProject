package com.namastenepal.namastenepal.namastenepal.MyProfile.Settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.namastenepal.namastenepal.namastenepal.Login.LoginScreenActivity;
import com.namastenepal.namastenepal.namastenepal.MyProfile.MyProfileActivity;
import com.namastenepal.namastenepal.namastenepal.R;

public class ScrollingActivity extends AppCompatActivity {
    TextView vLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScrollingActivity.this, MyProfileActivity.class);
                startActivity(intent);
            }
        });
        initComponent();
    }

    public void initComponent() {
        vLogout = findViewById(R.id.persnal_info);
        vLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}
