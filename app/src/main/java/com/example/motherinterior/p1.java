package com.example.motherinterior;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class p1 extends AppCompatActivity {
Button Comilla,chittaganj,dhanmondi15,baddahat,bangladeshCabinet,savar,animal,duplex;
    String url;
    RequestQueue requestQueue;
    String ButtonHolder;
    String HttpUrl = "http://www.mitechbd.com/project/project_details.php";
    Boolean CheckEditText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1);
        Comilla=(Button)findViewById(R.id.barura);

       chittaganj=(Button)findViewById(R.id.chittagang);
        dhanmondi15=(Button)findViewById(R.id.Danmondi);

        baddahat=(Button)findViewById(R.id.Bahaddarhat);
        bangladeshCabinet=(Button)findViewById(R.id.BangladeshCabinet);
        savar=(Button)findViewById(R.id.Savar);
        animal=(Button)findViewById(R.id.animal);
        duplex=(Button)findViewById(R.id.duplex);


        Comilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent=new Intent(p1.this,ProjectDescription.class);
                mainIntent.putExtra("message", "samoli");
                startActivity(mainIntent);
            }
        });
        chittaganj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent=new Intent(p1.this,ProjectDescription.class);
                mainIntent.putExtra("message", "Chattogram");
                startActivity(mainIntent);
            }
        });
        dhanmondi15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent=new Intent(p1.this,ProjectDescription.class);
                mainIntent.putExtra("message", "Dhanmondi-15");
                startActivity(mainIntent);
            }
        });

       baddahat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent=new Intent(p1.this,ProjectDescription.class);
                mainIntent.putExtra("message", "Baddahat");
                startActivity(mainIntent);
            }
        });
        bangladeshCabinet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent=new Intent(p1.this,ProjectDescription.class);
                mainIntent.putExtra("message", "Bangladesh_Cabinet");
                startActivity(mainIntent);
            }
        });
        savar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent=new Intent(p1.this,ProjectDescription.class);
                mainIntent.putExtra("message", "Savar");
                startActivity(mainIntent);
            }
        });
        animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent=new Intent(p1.this,ProjectDescription.class);
                mainIntent.putExtra("message", "Animal_Resource");
                startActivity(mainIntent);
            }
        });
        duplex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent=new Intent(p1.this,ProjectDescription.class);
                mainIntent.putExtra("message", "Duplex_Stair");
                startActivity(mainIntent);
            }
        });

    }




}
