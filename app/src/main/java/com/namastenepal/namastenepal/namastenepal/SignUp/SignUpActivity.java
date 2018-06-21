package com.namastenepal.namastenepal.namastenepal.SignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.namastenepal.namastenepal.namastenepal.R;

public class SignUpActivity extends AppCompatActivity {
    Button vStart_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        vStart_Button = findViewById(R.id.start_Button);
        vStart_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, NameSignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
