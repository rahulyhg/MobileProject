package com.namastenepal.namastenepal.namastenepal.SignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.namastenepal.namastenepal.namastenepal.R;

public class NameSignUpActivity extends AppCompatActivity {
    Button vSaveButtonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_sign_up);
        vSaveButtonName = findViewById(R.id.save_Button_name);
        vSaveButtonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NameSignUpActivity.this, DobActivity.class);
                startActivity(intent);
            }
        });
    }
}
