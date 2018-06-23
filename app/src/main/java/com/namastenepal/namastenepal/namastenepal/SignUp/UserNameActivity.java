package com.namastenepal.namastenepal.namastenepal.SignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.namastenepal.namastenepal.namastenepal.R;

public class UserNameActivity extends AppCompatActivity {

    EditText vUsername;
    Button vUsername_button;
    public static String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_name);
        init();
        vUsername_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Username = vUsername.getText().toString();
                Intent intent = new Intent(UserNameActivity.this, PasswordSignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    public void init() {
        vUsername = findViewById(R.id.input_username);
        vUsername_button = findViewById(R.id.save_Button_username);
    }
}
