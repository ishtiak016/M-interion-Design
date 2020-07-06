package com.example.motherinterior;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.Manifest;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.FileUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.io.FilenameFilter;
import java.net.FileNameMap;
import java.util.ArrayList;

import static android.os.Environment.DIRECTORY_DOWNLOADS;
import static androidx.viewpager.widget.ViewPager.*;
import static com.example.motherinterior.Main2Activity.EXTRA_CREATOR;
import static com.example.motherinterior.Main2Activity.EXTRA_LIKES;
import static com.example.motherinterior.Main2Activity.EXTRA_URL;


public class DetailsActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;

    private ScaleGestureDetector mScalDetector;
    private float mScale = 1.0f;
    GestureDetector gestureDetector;
    private ImageView imageView;

    ScaleGestureDetector scaleGestureDetector;
    String urlimage;
    private Button downloadButton;
    public static final int PERMISSION_WRITE = 0;
    ProgressDialog progressDialog;
    String imageUrl;
    Bitmap bitmap;
    String kopa;
    float mScaleFactor;
    private LayoutInflater layoutInflater;
    ArrayList<String> l1 = new ArrayList<String>();
    private static final int WRITE_EXTERNAL_STORAGE_CODE = 1;
    ImageView imageViewl;
    private String currentImage;
    private RxPermissions rxPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        progressDialog = new ProgressDialog(this);

        rxPermissions = new RxPermissions(this);

        Intent intent = getIntent();
        imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        int likeCount = intent.getIntExtra(EXTRA_LIKES, 0);

        l1 = intent.getStringArrayListExtra("imageUrlAll");
        l1.add(0, imageUrl);


        //  String gg = intent.getStringExtra("download");


        downloadButton = (Button) findViewById(R.id.btnDownload);
        downloadButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= 23) {
                    if (checkPermission()) {
                        // Code for above or equal 23 API Oriented Device
                        // Your Permission granted already .Do next code
                        downloadImage(currentImage);

                    } else {
                        requestPermission(); // Code for permission
                    }
                } else {

                    // Code for Below 23 API Oriented Device
                    // Do next code
                    downloadImage(currentImage);

                }

                // Must be done during an initialization phase like onCreate
//                rxPermissions
//                        .request(Manifest.permission.CAMERA)
//                        .subscribe(granted -> {
//                            if (granted) { // Always true pre-M
//                                // I can control the camera now
//                            } else {
//                                // Oups permission denied
//                            }
//                        });
//                  downloadImage(currentImage);
            }
        });

        //  TextView textViewDetailsCreator = (TextView) findViewById(R.id.text_view_creator_detail);
        //   TextView textViewDetailsLike = (TextView) findViewById(R.id.text_view_like_detail);

        ViewPager viewPager = (ViewPager) findViewById(R.id.vpPager);
        viewPageAdapter adapter = new viewPageAdapter(this, l1);
        viewPager.setAdapter(adapter);

        currentImage = l1.get(0);

        viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentImage = l1.get(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        int ch2 = viewPager.getCurrentItem();
        String s = String.valueOf(ch2);
        Log.d("getCurrentItem", s);


    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(this, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("value", "Permission Granted, Now you can use local drive .");
                } else {
                    Log.e("value", "Permission Denied, You cannot use local drive .");
                }
                break;
        }
    }

    private void downloadImage(String imageUrl) {

        if (imageUrl != null) {
            DownloadManager downloadmanager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri = Uri.parse(imageUrl);

            String fileName = imageUrl.substring(imageUrl.lastIndexOf('/') + 1, imageUrl.length());

//        String fileNameWithoutExtn = fileName.substring(0, fileName.lastIndexOf('.'));

            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE)
                    .setDestinationInExternalPublicDir(DIRECTORY_DOWNLOADS + File.separator, uri.getLastPathSegment())
                    .setTitle(fileName)
                    .setDescription(fileName)
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            downloadmanager.enqueue(request);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        scaleGestureDetector.onTouchEvent(motionEvent);
        return true;

    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            mScaleFactor = scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
            imageViewl.setScaleX(mScaleFactor);
            imageViewl.setScaleY(mScaleFactor);
            return true;
        }
    }
}

