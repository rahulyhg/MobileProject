package com.namastenepal.namastenepal.namastenepal.SignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.namastenepal.namastenepal.namastenepal.R;

public class GenderSignUpActivity extends AppCompatActivity {
    Button vButton_Gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        vButton_Gender = findViewById(R.id.save_Button_gender);
        vButton_Gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GenderSignUpActivity.this, EmailSignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
