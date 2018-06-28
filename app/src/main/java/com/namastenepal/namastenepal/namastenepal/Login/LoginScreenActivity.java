package com.namastenepal.namastenepal.namastenepal.Login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.namastenepal.namastenepal.namastenepal.Login.Service.LoginService;
import com.namastenepal.namastenepal.namastenepal.Login.Service.ServiceGenerator;
import com.namastenepal.namastenepal.namastenepal.Login.Service.User;
import com.namastenepal.namastenepal.namastenepal.MainActivity.MainActivity;
import com.namastenepal.namastenepal.namastenepal.R;
import com.namastenepal.namastenepal.namastenepal.SignUp.SignUpActivity;
import com.namastenepal.namastenepal.namastenepal.forgetPassword.ForgetPasswordActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginScreenActivity extends AppCompatActivity {

    private static final boolean AUTO_HIDE = true;
    private static final int AUTO_HIDE_DELAY_MILLIS = 5000;
    private static final int UI_ANIMATION_DELAY = 900000000;
    private final Handler mHideHandler = new Handler();
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
        }
    };
    private TextView vInput_Email;
    private TextView vInput_Password;
    private Button vLogin_Button;
    private Button vSign_Up_Button;
    private TextView vSignUpHere_TextView;
    private TextView vForgetPassword_TextView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_screen);
        initComponent();

        mVisible = true;

        vLogin_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreenActivity.this, MainActivity.class);
                startActivity(intent);
          //      checkData();
            }
        });
        vSign_Up_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreenActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        vForgetPassword_TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreenActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initComponent() {
        vSign_Up_Button = findViewById(R.id.Sign_Up_Button);
        vLogin_Button = findViewById(R.id.login_Button);
        vForgetPassword_TextView = findViewById(R.id.forget_password_text);
        vInput_Email = findViewById(R.id.input_email_login);
        vInput_Password = findViewById(R.id.input_password_login);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        delayedHide(3000);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mVisible = false;
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        mVisible = true;
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    public void checkData() {
        LoginService loginService =
                ServiceGenerator.createService(LoginService.class, vInput_Email.getText().toString(), vInput_Password.getText().toString());
        Call<User> call = loginService.basicLogin();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "" + response, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "" + response, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
