package com.namastenepal.namastenepal.namastenepal.SignUp;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.namastenepal.namastenepal.namastenepal.ApiClient.ApiClient;
import com.namastenepal.namastenepal.namastenepal.MainActivity.Fragments.SamajFragment.SamajDto;
import com.namastenepal.namastenepal.namastenepal.R;
import com.namastenepal.namastenepal.namastenepal.SignUp.SignUpDto.SignUpDto;
import com.namastenepal.namastenepal.namastenepal.SignUp.SignUpService.SignUpService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.namastenepal.namastenepal.namastenepal.SignUp.EmailSignUpActivity.Email;
import static com.namastenepal.namastenepal.namastenepal.SignUp.SignUpDto.SignUpDto.signUpDtoList;
import static com.namastenepal.namastenepal.namastenepal.SignUp.UserNameActivity.Username;

public class PasswordSignUpActivity extends AppCompatActivity {
    SignUpService IcSignUpService;
    List<SamajDto> signUpDtoSignUpDto = new ArrayList<>();
    Button vSaveSignUp;
    SignUpDto IcSignUpDto;
    EditText vPassword;
    private String password;
    RelativeLayout vRelativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_sign_up);
        init();
        vSaveSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password = vPassword.getText().toString();
                saveData();
            }
        });
    }

    public void saveData() {
        SignUpService IsignUpService = ApiClient.getApiClient().create(SignUpService.class);
        IcSignUpDto = new SignUpDto(Email, password, password, Username);
        Call<SignUpDto> call = IsignUpService.signUp(IcSignUpDto);
        call.enqueue(new Callback<SignUpDto>() {
            @Override
            public void onResponse(Call<SignUpDto> call, Response<SignUpDto> response) {
                Toast.makeText(getApplicationContext(), "" + response.body(), Toast.LENGTH_LONG).show();
                Snackbar snackbar = Snackbar.make(vRelativeLayout, "Confirmation Email Sent", Snackbar.LENGTH_LONG);
                snackbar.show();
            }

            @Override
            public void onFailure(Call<SignUpDto> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + call, Toast.LENGTH_LONG).show();
            }
        });

    }


    public void init() {
        vPassword = findViewById(R.id.input_password);
        vSaveSignUp = findViewById(R.id.save_Signup_name);
        vRelativeLayout = findViewById(R.id.relativePassword);
    }
}
