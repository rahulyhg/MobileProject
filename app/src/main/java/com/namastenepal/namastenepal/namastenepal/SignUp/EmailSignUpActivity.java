package com.namastenepal.namastenepal.namastenepal.SignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.namastenepal.namastenepal.namastenepal.R;

public class EmailSignUpActivity extends AppCompatActivity {
    Button vButtonEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_sign_up);
        vButtonEmail = findViewById(R.id.save_Button_email);
        vButtonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmailSignUpActivity.this, PasswordSignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
