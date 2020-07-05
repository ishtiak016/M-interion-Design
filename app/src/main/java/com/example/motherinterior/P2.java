package com.example.motherinterior;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class P2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2);
        String TempHolder = getIntent().getStringExtra("UserEmailTAG");
        Toast.makeText(this,""+TempHolder,Toast.LENGTH_LONG).show();
    }
}
