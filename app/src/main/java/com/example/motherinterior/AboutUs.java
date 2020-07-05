package com.example.motherinterior;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {
TextView about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        about=(TextView)findViewById(R.id.textView4);
        about.setText("Mother Interior is a name that is providing Quality Modern Interior Design." +
                " Our professional's have a combined experience with " +
                "interior Design & furniture production of over 12 years. Their technical skills " +
                "and experiences are not only limited with in the territory of Bangladesh rather it has broadened through " +
                "out the many countries. We have an Expert Architecture & technical team");
    }
}
