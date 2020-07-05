package com.example.motherinterior;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
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

import java.util.ArrayList;

import static androidx.viewpager.widget.ViewPager.*;
import static com.example.motherinterior.Main2Activity.EXTRA_CREATOR;
import static com.example.motherinterior.Main2Activity.EXTRA_LIKES;
import static com.example.motherinterior.Main2Activity.EXTRA_URL;


public class DetailsActivity extends AppCompatActivity  {
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
    private static final int WRITE_EXTERNAL_STORAGE_CODE=1;
    ImageView imageViewl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        progressDialog = new ProgressDialog(this);

        Intent intent = getIntent();
        imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        int likeCount = intent.getIntExtra(EXTRA_LIKES, 0);

        l1 = intent.getStringArrayListExtra("imageUrlAll");
        l1.add(0, imageUrl);


      //  String gg = intent.getStringExtra("download");


      //  downloadButton = (Button) findViewById(R.id.downloadButton);

      //  TextView textViewDetailsCreator = (TextView) findViewById(R.id.text_view_creator_detail);
     //   TextView textViewDetailsLike = (TextView) findViewById(R.id.text_view_like_detail);

        ViewPager viewPager = (ViewPager) findViewById(R.id.vpPager);
        viewPageAdapter adapter = new viewPageAdapter(this, l1);
        viewPager.setAdapter(adapter);





   int ch2=viewPager.getCurrentItem();
   String s= String.valueOf(ch2);
   Log.d("string",s);


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

