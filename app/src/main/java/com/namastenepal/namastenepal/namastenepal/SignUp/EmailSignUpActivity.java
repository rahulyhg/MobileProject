package com.namastenepal.namastenepal.namastenepal.SignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.namastenepal.namastenepal.namastenepal.R;

public class EmailSignUpActivity extends AppCompatActivity {
    Button vButtonEmail;
    EditText vEmail;
    public static String Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_sign_up);
        init();
        vButtonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email = vEmail.getText().toString();
                Intent intent = new Intent(EmailSignUpActivity.this, UserNameActivity.class);
                startActivity(intent);
            }
        });
    }

    public void init() {
        vEmail = findViewById(R.id.input_email);
        vButtonEmail = findViewById(R.id.save_Button_email);
    }
}
