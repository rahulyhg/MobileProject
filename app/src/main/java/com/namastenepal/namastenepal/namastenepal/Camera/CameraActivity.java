package com.namastenepal.namastenepal.namastenepal.Camera;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.namastenepal.namastenepal.namastenepal.ImageFilter.ImageFilter;
import com.namastenepal.namastenepal.namastenepal.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class CameraActivity extends AppCompatActivity implements Callback {
    int numberOfCamera;
    ImageButton vOpenGallery;
    ImageButton vCameraButton;
    ImageButton vSelfie;
    ImageButton vEditor;
    ProgressBar vProgressBar;
    private boolean previewRunning;
    boolean previewing = false;
    private SurfaceView surview;
    private RelativeLayout CamView;
    private ImageView all;
    private Bitmap bmp1;
    private SurfaceHolder camHolder;
    int camId = 0;
    Parameters camParams;
    Camera camera = Camera.open();

    final Context context = this;
    int count = 0;
    int[] images = new int[]{R.mipmap.chalfal, R.drawable.ic_launcher_background};
    private ImageView mImage;
    private PictureCallback mPicture = new PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {
            File dir_image2 = new File(Environment.getExternalStorageDirectory() + File.separator + "Hamro Pahiran");
            dir_image2.mkdirs();
            File tmpFile = new File(dir_image2, "TempPic.jpg");
            try {
                FileOutputStream fos = new FileOutputStream(tmpFile);
                Bitmap realImage = BitmapFactory.decodeByteArray(data, 0, data.length);
                ExifInterface exif = new ExifInterface(dir_image2.toString());
                if (exif.getAttribute("Orientation").equalsIgnoreCase("6")) {
                    realImage = CameraActivity.rotate(realImage, 90);
                } else if (exif.getAttribute("Orientation").equalsIgnoreCase("8")) {
                    realImage = CameraActivity.rotate(realImage, 270);
                } else if (exif.getAttribute("Orientation").equalsIgnoreCase("3")) {
                    realImage = CameraActivity.rotate(realImage, 180);
                } else if (exif.getAttribute("Orientation").equalsIgnoreCase("0")) {
                    realImage = CameraActivity.rotate(realImage, 90);
                }
                boolean bo = realImage.compress(CompressFormat.JPEG, 100, fos);
                fos.write(data);
                fos.close();
            } catch (FileNotFoundException e) {
                Toast.makeText(CameraActivity.this.getApplicationContext(), "Error1", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            } catch (IOException e2) {
                Toast.makeText(CameraActivity.this.getApplicationContext(), "Error2", Toast.LENGTH_SHORT).show();
                e2.printStackTrace();
            }
            String path = Environment.getExternalStorageDirectory() + File.separator + "Hamro Pahiran" + File.separator + "TempPic.jpg";
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            CameraActivity.this.bmp1 = BitmapFactory.decodeFile(path, options);
            CameraActivity.this.mImage.setImageBitmap(CameraActivity.this.bmp1);
            tmpFile.delete();
            CameraActivity.this.TakeScreenShot();
        }
    };


    public class OnSwipeTouchListener implements OnTouchListener {
        private final GestureDetector gestureDetector;

        private final class GestureListener extends SimpleOnGestureListener {

            private GestureListener() {
            }

            public boolean onDown(MotionEvent e) {
                return true;
            }

            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                try {
                    float diffY = e2.getY() - e1.getY();
                    float diffX = e2.getX() - e1.getX();
                    if (Math.abs(diffX) > Math.abs(diffY)) {
                        if (Math.abs(diffX) > 100.0f && Math.abs(velocityX) > 100.0f) {
                            if (diffX > 0.0f) {
                                OnSwipeTouchListener.this.onSwipeRight();
                            } else {
                                OnSwipeTouchListener.this.onSwipeLeft();
                            }
                        }
                    } else if (Math.abs(diffY) > 100.0f && Math.abs(velocityY) > 100.0f) {
                        if (diffY > 0.0f) {
                            OnSwipeTouchListener.this.onSwipeBottom();
                        } else {
                            OnSwipeTouchListener.this.onSwipeTop();
                        }
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                return false;
            }
        }

        public OnSwipeTouchListener(Context ctx) {
            this.gestureDetector = new GestureDetector(ctx, new GestureListener());
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.gestureDetector.onTouchEvent(motionEvent);
        }

        public void onSwipeRight() {
        }

        public void onSwipeLeft() {
        }

        public void onSwipeTop() {
        }

        public void onSwipeBottom() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_activity);
        camera.setDisplayOrientation(90);
        CamView = findViewById(R.id.camview);
        mImage = findViewById(R.id.camera_image);
        all = findViewById(R.id.camera_imagee);
        surview = findViewById(R.id.sview);
        vProgressBar = findViewById(R.id.progress_bar);
        vOpenGallery = findViewById(R.id.gallery);
        vCameraButton = findViewById(R.id.button1);
        vEditor = findViewById(R.id.edit);
        vSelfie = findViewById(R.id.selfie);
        vProgressBar.setVisibility(View.GONE);
        vEditor.setVisibility(View.VISIBLE);
        vSelfie.setVisibility(View.VISIBLE);
        vOpenGallery.setVisibility(View.VISIBLE);
        vCameraButton.setVisibility(View.VISIBLE);
        vSelfie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openFrontFacingCamera();
            }
        });
        vEditor.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CameraActivity.this, ImageFilter.class);
                startActivity(intent);
            }
        });
        vCameraButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                vSelfie.setVisibility(View.GONE);
                vOpenGallery.setVisibility(View.GONE);
                vCameraButton.setVisibility(View.GONE);
                vEditor.setVisibility(View.GONE);
                // CameraActivity.this.camera.takePicture(null, null, CameraActivity.this.mPicture);

            }
        });
        vOpenGallery.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CameraActivity.this.startActivityForResult(new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI), 0);
                } catch (Exception e) {
                    Toast.makeText(CameraActivity.this.context, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });
        this.camHolder = this.surview.getHolder();
        this.camHolder.addCallback(this);
        this.camHolder.setType(3);
        this.CamView.setOnTouchListener(new OnSwipeTouchListener(this) {
            public void onSwipeTop() {
            }

            public void onSwipeLeft() {
                if (CameraActivity.this.count < CameraActivity.this.images.length - 1) {
                    CameraActivity cameraActivity = CameraActivity.this;
                    cameraActivity.count++;
                    //  CameraActivity.this.mImage.setBackgroundResource(CameraActivity.this.images[CameraActivity.this.count]);
                    CameraActivity.this.all.setBackgroundResource(CameraActivity.this.images[CameraActivity.this.count]);
                }
            }

            public void onSwipeRight() {
                if (CameraActivity.this.count > 0) {
                    CameraActivity cameraActivity = CameraActivity.this;
                    cameraActivity.count--;
                }
                // CameraActivity.this.mImage.setBackgroundResource(CameraActivity.this.images[CameraActivity.this.count]);
                CameraActivity.this.all.setBackgroundResource(CameraActivity.this.images[CameraActivity.this.count]);
            }

            public void onSwipeBottom() {
            }
        });
    }

    public static Bitmap rotate(Bitmap bitmap, int degree) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Matrix mtx = new Matrix();
        mtx.setRotate((float) degree);
        return Bitmap.createBitmap(bitmap, 0, 0, w, h, mtx, true);
    }

    public void TakeScreenShot() {
        int nu = new Random().nextInt(1000);
        this.CamView.setDrawingCacheEnabled(true);
        this.CamView.buildDrawingCache(true);
        Toast.makeText(getApplicationContext(), "Error1", Toast.LENGTH_SHORT).show();
        Bitmap bmp = Bitmap.createBitmap(this.CamView.getDrawingCache());
        this.CamView.setDrawingCacheEnabled(false);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bmp.compress(CompressFormat.JPEG, 100, bos);
        ByteArrayInputStream fis = new ByteArrayInputStream(bos.toByteArray());
        String myfile = "HamroPhoto" + String.valueOf(nu) + ".jpeg";
        vProgressBar.setVisibility(View.VISIBLE);
        File dir_image = new File(Environment.getExternalStorageDirectory() + File.separator + "Hamro Pahiran");
        dir_image.mkdirs();
        try {
            FileOutputStream fos = new FileOutputStream(new File(dir_image, myfile));
            byte[] buf = new byte[1024];
            while (true) {
                int len = fis.read(buf);
                if (len > 0) {
                    fos.write(buf, 0, len);
                } else {
                    vProgressBar.setVisibility(View.GONE);
                    vEditor.setVisibility(View.VISIBLE);
                    vCameraButton.setVisibility(View.VISIBLE);
                    vOpenGallery.setVisibility(View.VISIBLE);
                    vSelfie.setVisibility(View.VISIBLE);
                    fis.close();
                    fos.close();
                    Toast.makeText(getApplicationContext(), "This file is Saved", Toast.LENGTH_SHORT).show();
                    this.bmp1 = null;
                    this.mImage.setImageBitmap(this.bmp1);
                    this.camera.startPreview();
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void openFrontFacingCamera() {
        this.numberOfCamera = Camera.getNumberOfCameras();
        if (this.camId == 0) {
            this.camId = 1;
            Toast.makeText(getApplicationContext(), "BACK TO FRONT", Toast.LENGTH_SHORT).show();
            try {
                this.camera.release();
                this.camera = Camera.open(this.camId);
                this.camera.setDisplayOrientation(90);
                this.camera.setPreviewDisplay(this.camHolder);
                this.camera.startPreview();
                this.previewing = true;
            } catch (RuntimeException e) {
            } catch (IOException e2) {
            }
        } else if (this.camId == 1) {
            this.camId = 0;
            Toast.makeText(getApplicationContext(), "FRONT TO BACK", Toast.LENGTH_SHORT).show();
            try {
                this.camera.release();
                this.camera = Camera.open(this.camId);
                this.camera.setDisplayOrientation(90);
                this.camera.setPreviewDisplay(this.camHolder);
                this.camera.startPreview();
            } catch (RuntimeException e3) {
            } catch (IOException e4) {
            }
        }
    }

    public void surfaceCreated(SurfaceHolder holder) {
//        try {
//            this.camera.setDisplayOrientation(90);
//            this.camera = Camera.open();
//            Parameters p = this.camera.getParameters();
//            p.setFlashMode("auto");
//            this.camera.setParameters(p);
//            this.camera.setPreviewDisplay(holder);
//        } catch (Exception e) {
//            Toast.makeText(getApplicationContext(), "Error+Error", Toast.LENGTH_SHORT).show();
//            finish();
//        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        this.camera = Camera.open(this.camId);
        this.camParams = this.camera.getParameters();
        Size size = (Size) this.camParams.getSupportedPreviewSizes().get(0);
        this.camParams.setPreviewSize(size.width, size.height);
        this.camera.setDisplayOrientation(90);
        this.camera.setParameters(this.camParams);
        try {
            this.camera.setPreviewDisplay(holder);
            this.camera.startPreview();
            this.previewRunning = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        refreshCamera();
    }

    public void refreshCamera() {
        if (this.camHolder.getSurface() != null) {
            try {
                this.camera.stopPreview();
            } catch (Exception e) {
            }
            try {
                this.camera.setPreviewDisplay(this.camHolder);
                this.camera.startPreview();
            } catch (Exception e2) {
            }
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        this.camera.stopPreview();
        this.camera.release();
        this.camera = null;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
