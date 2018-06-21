package com.namastenepal.namastenepal.namastenepal.SignUp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.namastenepal.namastenepal.namastenepal.R;

import java.util.Calendar;

public class DobActivity extends AppCompatActivity {
    Button vButton_Dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dob);
        vButton_Dob = findViewById(R.id.save_Button_dob);
        vButton_Dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DobActivity.this, GenderSignUpActivity.class);
                startActivity(intent);
            }
        });
    }


}
