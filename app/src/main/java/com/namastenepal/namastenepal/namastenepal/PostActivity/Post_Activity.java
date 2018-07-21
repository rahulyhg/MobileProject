package com.namastenepal.namastenepal.namastenepal.PostActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.namastenepal.namastenepal.namastenepal.MapsActivity.MapsActivity;
import com.namastenepal.namastenepal.namastenepal.R;

public class Post_Activity extends AppCompatActivity {
    BottomSheetLayout vBottomSheetLayout;
    TextView vMapActivity;
    RelativeLayout relativeLayoutV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_);
        initComponent();
    }

    public void initComponent() {
        vBottomSheetLayout = findViewById(R.id.post_bottomsheet);
        vBottomSheetLayout.showWithSheetView(LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet_layout_post, vBottomSheetLayout, false));
        vBottomSheetLayout.setPeekSheetTranslation((float) 500.00);
        vMapActivity = findViewById(R.id.text);
        vMapActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });


        //        vCamera_Share_ImageView = view.findViewById(R.id.camera_share);
//        vCamera_Share_TextView = view.findViewById(R.id.camera_share_text);


        //        vCamera_Share_TextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), CameraActivity.class);
//                startActivity(intent);
//            }
//        });
//        vCamera_Share_ImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), CameraActivity.class);
//                startActivity(intent);
//            }
//        });

    }
}
