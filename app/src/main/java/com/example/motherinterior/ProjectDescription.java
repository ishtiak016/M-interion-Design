package com.example.motherinterior;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDescription extends AppCompatActivity implements ProjectAdapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private ProjectAdapter mExampleAdapter;
    private ArrayList<ProjectItem> mExampleList;
    private ArrayList<String> Images;
    private RequestQueue mRequestQueue;
    String url_final;
    String TempName,TempEmail;
     String url,url1;

    public static final String EXTRA_URL="imageUrl";
    public static final String EXTRA_PROJECT_NAME="projectName";
    public static final String EXTRA_DESCRIPTION="description";
    public static final String EXTRA_LOCATION="location";
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_description);
    mRecyclerView=(RecyclerView)findViewById(R.id.my_recycler_view);
    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mExampleList=new ArrayList<>();
    Images=new ArrayList<>();
    mRequestQueue= Volley.newRequestQueue(this);
  Intent intent = getIntent();

    String str = intent.getStringExtra("message");
    url_final="http://www.mitechbd.com/project/project_details.php";
    Toast.makeText(this,""+str,Toast.LENGTH_LONG).show();
   if(str=="Comilla"){
     ParseJSONc(url_final);
 }
 else if(str.equals("Chattogram")){
     ParseJSONch(url_final);
 }else if(str.equals("Dhanmondi-15")){
      ParseJSONdh(url_final);
   }else if(str.equals("Baddahat")){
    ParseJSONba(url_final);
  } else if(str.equals("Bangladesh_Cabinet")){
   ParseJSONban(url_final);
  } else if(str.equals("Savar")){
      ParseJSONsav(url_final);
    }
 else if(str.equals("Animal_Resource")){
  ParseJSONani(url_final);
 } else if(str.equals("Duplex_Stair"))
  {
      ParseJSONdu(url_final);
   }else{
     ParseJSON(url_final);
  }


        }
    private void ParseJSON(String s) {

        String base_url="http://www.mitechbd.com/project/project_details.php";
         url="http://www.mitechbd.com/project/project_details.php";


        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //                mProgressBar.setVisibility(GONE);

                            JSONArray jsonArray=response.getJSONArray("hits");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject hit=jsonArray.getJSONObject(i);
                                String projectName=hit.getString("project_name");
                                String description=hit.getString("description");
                                String imageUrl=hit.getString("image");
                                String location=hit.getString("location");
                                    if(projectName.equals("samoli"))
                                    {
                                        Images.add(imageUrl);
                                        mExampleList.add(new ProjectItem(imageUrl,projectName,description,location));
                                    }


                            }

                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,LinearLayoutManager.VERTICAL,false);
                            mRecyclerView.setLayoutManager(gridLayoutManager);
                            mExampleAdapter=new ProjectAdapter(ProjectDescription.this,mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnClickListener(ProjectDescription.this);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("bangladesh",url);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(7000);
                            Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }).start();
                Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                Log.w("error in response", "Error: " + error.getMessage());;
            }
        });

        mRequestQueue.add(request);

    }
    private void ParseJSONc(String s) {

        String base_url="http://www.mitechbd.com/project/project_details.php";
        url="http://www.mitechbd.com/project/project_details.php";


        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //                mProgressBar.setVisibility(GONE);

                            JSONArray jsonArray=response.getJSONArray("hits");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject hit=jsonArray.getJSONObject(i);
                                String projectName=hit.getString("project_name");
                                String description=hit.getString("description");
                                String imageUrl=hit.getString("image");
                                String location=hit.getString("location");
                                if(projectName.equals("Comilla"))
                                {
                                    Images.add(imageUrl);
                                    mExampleList.add(new ProjectItem(imageUrl,projectName,description,location));
                                }


                            }

                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,LinearLayoutManager.VERTICAL,false);
                            mRecyclerView.setLayoutManager(gridLayoutManager);
                            mExampleAdapter=new ProjectAdapter(ProjectDescription.this,mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnClickListener(ProjectDescription.this);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("bangladesh",url);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(7000);
                            Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }).start();
                Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                Log.w("error in response", "Error: " + error.getMessage());;
            }
        });

        mRequestQueue.add(request);

    }
    private void ParseJSONch(String s) {

        String base_url="http://www.mitechbd.com/project/project_details.php";
        url="http://www.mitechbd.com/project/project_details.php";


        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //                mProgressBar.setVisibility(GONE);

                            JSONArray jsonArray=response.getJSONArray("hits");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject hit=jsonArray.getJSONObject(i);
                                String projectName=hit.getString("project_name");
                                String description=hit.getString("description");
                                String imageUrl=hit.getString("image");
                                String location=hit.getString("location");
                                if(projectName.equals("Chattogram"))
                                {
                                    Images.add(imageUrl);
                                    mExampleList.add(new ProjectItem(imageUrl,projectName,description,location));
                                }


                            }

                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,LinearLayoutManager.VERTICAL,false);
                            mRecyclerView.setLayoutManager(gridLayoutManager);
                            mExampleAdapter=new ProjectAdapter(ProjectDescription.this,mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnClickListener(ProjectDescription.this);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("bangladesh",url);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(7000);
                            Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }).start();
                Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                Log.w("error in response", "Error: " + error.getMessage());;
            }
        });

        mRequestQueue.add(request);

    }
    private void ParseJSONdh(String s) {

        String base_url="http://www.mitechbd.com/project/project_details.php";
        url="http://www.mitechbd.com/project/project_details.php";


        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //                mProgressBar.setVisibility(GONE);

                            JSONArray jsonArray=response.getJSONArray("hits");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject hit=jsonArray.getJSONObject(i);
                                String projectName=hit.getString("project_name");
                                String description=hit.getString("description");
                                String imageUrl=hit.getString("image");
                                String location=hit.getString("location");
                                if(projectName.equals("Dhanmondi-15"))
                                {
                                    Images.add(imageUrl);
                                    mExampleList.add(new ProjectItem(imageUrl,projectName,description,location));
                                }


                            }

                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,LinearLayoutManager.VERTICAL,false);
                            mRecyclerView.setLayoutManager(gridLayoutManager);
                            mExampleAdapter=new ProjectAdapter(ProjectDescription.this,mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnClickListener(ProjectDescription.this);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("bangladesh",url);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(7000);
                            Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }).start();
                Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                Log.w("error in response", "Error: " + error.getMessage());;
            }
        });

        mRequestQueue.add(request);

    }
    private void ParseJSONba(String s) {

        String base_url="http://www.mitechbd.com/project/project_details.php";
        url="http://www.mitechbd.com/project/project_details.php";


        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //                mProgressBar.setVisibility(GONE);

                            JSONArray jsonArray=response.getJSONArray("hits");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject hit=jsonArray.getJSONObject(i);
                                String projectName=hit.getString("project_name");
                                String description=hit.getString("description");
                                String imageUrl=hit.getString("image");
                                String location=hit.getString("location");
                                if(projectName.equals("Baddahat"))
                                {
                                    Images.add(imageUrl);
                                    mExampleList.add(new ProjectItem(imageUrl,projectName,description,location));
                                }


                            }

                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,LinearLayoutManager.VERTICAL,false);
                            mRecyclerView.setLayoutManager(gridLayoutManager);
                            mExampleAdapter=new ProjectAdapter(ProjectDescription.this,mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnClickListener(ProjectDescription.this);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("bangladesh",url);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(7000);
                            Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }).start();
                Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                Log.w("error in response", "Error: " + error.getMessage());;
            }
        });

        mRequestQueue.add(request);

    }
    private void ParseJSONban(String s) {

        String base_url="http://www.mitechbd.com/project/project_details.php";
        url="http://www.mitechbd.com/project/project_details.php";


        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //                mProgressBar.setVisibility(GONE);

                            JSONArray jsonArray=response.getJSONArray("hits");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject hit=jsonArray.getJSONObject(i);
                                String projectName=hit.getString("project_name");
                                String description=hit.getString("description");
                                String imageUrl=hit.getString("image");
                                String location=hit.getString("location");
                                if(projectName.equals("bangladeshCabinet"))
                                {
                                    Images.add(imageUrl);
                                    mExampleList.add(new ProjectItem(imageUrl,projectName,description,location));
                                }


                            }

                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,LinearLayoutManager.VERTICAL,false);
                            mRecyclerView.setLayoutManager(gridLayoutManager);
                            mExampleAdapter=new ProjectAdapter(ProjectDescription.this,mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnClickListener(ProjectDescription.this);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("bangladesh",url);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(7000);
                            Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }).start();
                Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                Log.w("error in response", "Error: " + error.getMessage());;
            }
        });

        mRequestQueue.add(request);

    }
    private void ParseJSONsav(String s) {

        String base_url="http://www.mitechbd.com/project/project_details.php";
        url="http://www.mitechbd.com/project/project_details.php";


        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //                mProgressBar.setVisibility(GONE);

                            JSONArray jsonArray=response.getJSONArray("hits");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject hit=jsonArray.getJSONObject(i);
                                String projectName=hit.getString("project_name");
                                String description=hit.getString("description");
                                String imageUrl=hit.getString("image");
                                String location=hit.getString("location");
                                if(projectName.equals("Savar"))
                                {
                                    Images.add(imageUrl);
                                    mExampleList.add(new ProjectItem(imageUrl,projectName,description,location));
                                }


                            }

                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,LinearLayoutManager.VERTICAL,false);
                            mRecyclerView.setLayoutManager(gridLayoutManager);
                            mExampleAdapter=new ProjectAdapter(ProjectDescription.this,mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnClickListener(ProjectDescription.this);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("bangladesh",url);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(7000);
                            Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }).start();
                Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                Log.w("error in response", "Error: " + error.getMessage());;
            }
        });

        mRequestQueue.add(request);

    }
    private void ParseJSONani(String s) {

        String base_url="http://www.mitechbd.com/project/project_details.php";
        url="http://www.mitechbd.com/project/project_details.php";


        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //                mProgressBar.setVisibility(GONE);

                            JSONArray jsonArray=response.getJSONArray("hits");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject hit=jsonArray.getJSONObject(i);
                                String projectName=hit.getString("project_name");
                                String description=hit.getString("description");
                                String imageUrl=hit.getString("image");
                                String location=hit.getString("location");
                                if(projectName.equals("Animal"))
                                {
                                    Images.add(imageUrl);
                                    mExampleList.add(new ProjectItem(imageUrl,projectName,description,location));
                                }


                            }

                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,LinearLayoutManager.VERTICAL,false);
                            mRecyclerView.setLayoutManager(gridLayoutManager);
                            mExampleAdapter=new ProjectAdapter(ProjectDescription.this,mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnClickListener(ProjectDescription.this);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("bangladesh",url);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(7000);
                            Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }).start();
                Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                Log.w("error in response", "Error: " + error.getMessage());;
            }
        });

        mRequestQueue.add(request);

    }

    private void ParseJSONdu(String s) {

        String base_url="http://www.mitechbd.com/project/project_details.php";
        url="http://www.mitechbd.com/project/project_details.php";


        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //                mProgressBar.setVisibility(GONE);

                            JSONArray jsonArray=response.getJSONArray("hits");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject hit=jsonArray.getJSONObject(i);
                                String projectName=hit.getString("project_name");
                                String description=hit.getString("description");
                                String imageUrl=hit.getString("image");
                                String location=hit.getString("location");
                                if(projectName.equals("Duplex"))
                                {
                                    Images.add(imageUrl);
                                    mExampleList.add(new ProjectItem(imageUrl,projectName,description,location));
                                }


                            }

                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,LinearLayoutManager.VERTICAL,false);
                            mRecyclerView.setLayoutManager(gridLayoutManager);
                            mExampleAdapter=new ProjectAdapter(ProjectDescription.this,mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnClickListener(ProjectDescription.this);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("bangladesh",url);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(7000);
                            Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }).start();
                Toast.makeText(getApplicationContext(),"no Data Found",Toast.LENGTH_LONG).show();
                Log.w("error in response", "Error: " + error.getMessage());;
            }
        });

        mRequestQueue.add(request);

    }

    public void OnItemClick(int position) {
        Intent detailIntent=new Intent(this,ProjectFinalPage.class);
        ProjectItem clickItem=mExampleList.get(position);
        detailIntent.putExtra(EXTRA_URL,clickItem.getMimage());
        detailIntent.putExtra(EXTRA_PROJECT_NAME,clickItem.getMproject_name());
        detailIntent.putExtra(EXTRA_DESCRIPTION,clickItem.getMdescription());
        detailIntent.putExtra(EXTRA_LOCATION,clickItem.getMlocation());
        detailIntent.putExtra("imageUrlAll", Images);
        startActivity(detailIntent);

    }
}
