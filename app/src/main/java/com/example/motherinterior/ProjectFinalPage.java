
package com.example.motherinterior;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


import static com.example.motherinterior.ProjectDescription.EXTRA_DESCRIPTION;

import static com.example.motherinterior.ProjectDescription.EXTRA_LOCATION;
import static com.example.motherinterior.ProjectDescription.EXTRA_PROJECT_NAME;
import static com.example.motherinterior.ProjectDescription.EXTRA_URL;

public class ProjectFinalPage extends AppCompatActivity {
    private ScaleGestureDetector scaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private ImageView imageView;
    String urlimage;
    private Button downloadButton;
    public static final int PERMISSION_WRITE = 0;
    ProgressDialog progressDialog;
    String imageUrl;
    Bitmap bitmap;
    String kopa;
    ArrayList<String> l1 = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_final_page);

        Intent intent=getIntent();
        imageUrl=intent.getStringExtra(EXTRA_URL);
        String projectName=intent.getStringExtra(EXTRA_PROJECT_NAME);
        String description=intent.getStringExtra(EXTRA_DESCRIPTION);
        String location=intent.getStringExtra(EXTRA_LOCATION);


        l1=intent.getStringArrayListExtra("imageUrlAll");
        l1.add(0,imageUrl);

     //   String gg=intent.getStringExtra("download");


       // downloadButton=(Button)findViewById(R.id.downloadButton);
       // Toast.makeText(getApplicationContext(),gg,Toast.LENGTH_LONG).show();

      //  TextView textViewDetailsCreator=(TextView)findViewById(R.id.text_view_creator_detail);
    //    TextView textViewDetailsLike=(TextView)findViewById(R.id.text_view_like_detail);

        ViewPager viewPager=(ViewPager)findViewById(R.id.vpPager);

        viewPageAdapter adapter= new viewPageAdapter(this,l1);
        viewPager.setAdapter(adapter);

        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());




        // textViewDetailsCreator.setText("productId: "+creatorName);
        //   textViewDetailsLike.setText("Likes :" +likeCount);
    }
    public boolean onTouchEvent(MotionEvent motionEvent) {
        scaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }
    protected class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
            imageView.setScaleX(mScaleFactor);
            imageView.setScaleY(mScaleFactor);
            return true;
        }
    }
}
