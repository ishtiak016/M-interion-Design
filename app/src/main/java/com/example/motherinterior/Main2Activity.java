package com.example.motherinterior;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class Main2Activity extends AppCompatActivity implements ExampleAdapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private ArrayList<String> Images;
    private RequestQueue mRequestQueue;
    String url_final;
    private ProgressBar mProgressBar;
    ProgressDialog progressDialog;

    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_CREATOR = "creatorName";
    public static final String EXTRA_LIKES = "likeCount";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        //mProgressBar.setIndeterminate(true);
        //mProgressBar.setVisibility(VISIBLE);

        progressDialog = new ProgressDialog(Main2Activity.this);
        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle("Please wait"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();
        Images = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        url_final = str;
        ParseJSON(url_final);


    }

    private void ParseJSON(String s) {
        String base_url = "https://www.mitechbd.com/";
        final String url = base_url + s;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            //                mProgressBar.setVisibility(GONE);
                            progressDialog.dismiss();
                            JSONArray jsonArray = response.getJSONArray("hits");

                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject hit = jsonArray.getJSONObject(i);
                                String creatorName = hit.getString("user");
                                String imageUrl = hit.getString("webformatURL");
                                int likeCount = hit.getInt("likes");
                                Images.add(imageUrl);

                                mExampleList.add(new ExampleItem(imageUrl, creatorName, likeCount));

                            }

                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, LinearLayoutManager.VERTICAL, false);
                            mRecyclerView.setLayoutManager(gridLayoutManager);
                            mExampleAdapter = new ExampleAdapter(Main2Activity.this, mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnClickListener(Main2Activity.this);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("banglades", url);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(4000);
                            Toast.makeText(getApplicationContext(), "no Data Found", Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                        progressDialog.dismiss();
                    }
                }).start();
                Toast.makeText(getApplicationContext(), "no Data Found", Toast.LENGTH_LONG).show();
                Log.w("error in response", "Error: " + error.getMessage());
                ;
            }
        });

        mRequestQueue.add(request);


    }


    @Override
    public void OnItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailsActivity.class);
        ExampleItem clickItem = mExampleList.get(position);
        detailIntent.putExtra(EXTRA_URL, clickItem.getmImageUrl());
        detailIntent.putExtra(EXTRA_CREATOR, clickItem.getmCreator());
        detailIntent.putExtra(EXTRA_LIKES, clickItem.getmLikes());
        detailIntent.putExtra("imageUrlAll", Images);
        startActivity(detailIntent);

    }
}
