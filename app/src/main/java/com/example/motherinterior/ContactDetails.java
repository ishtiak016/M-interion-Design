package com.example.motherinterior;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactDetails extends AppCompatActivity {
    Button call1,call2,facebook,youtube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        call1 = (Button) findViewById(R.id.phoneOnebutton);
        call2 = (Button) findViewById(R.id.phonetwobutton);
        facebook=(Button)findViewById(R.id.facebookButton);
        youtube=(Button)findViewById(R.id.youtubeButton);
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo = "+8801711940493";
                {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }
            }
        });
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo = "+8801755554266";
                {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }
            }
        });
       facebook.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                 gotoFacebookPage("942130559184254");
           }
       });
youtube.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.youtube.com/channel/UCJEzLIKZ4UVsi1P3iwNwvSg?fbclid=IwAR3hEpKMuTxUu8E40UUC0fHyuHRu0IiO73Cd15ByAnXPP1qssOquOI1CEwI")));
    }
});
    }
    private void gotoFacebookPage(String id){
        try{
              Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("fb://page/"+id));
              startActivity(intent);
        }catch (ActivityNotFoundException e){
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/"+id));
            startActivity(intent);
        }
    }


}
