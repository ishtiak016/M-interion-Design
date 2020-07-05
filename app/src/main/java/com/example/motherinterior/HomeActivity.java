package com.example.motherinterior;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button bedRoom,window,designGlass,designPaint,dininigRoom,jypsum,kidRoom,kitchen,duplexStair,mainDoor,readingDressing,wallCabinet;
        Button furniture,wallTv,drawingRoom,livingRoom,conventionHall,SwimingPool,resort,office,project,contact,ourClients,aboutUs;
    String url;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        bedRoom=(Button)findViewById(R.id.bedRoomButton);
        window=(Button)findViewById(R.id.windowButton);
        designGlass=(Button)findViewById(R.id.designGlassButton);
        designPaint=(Button)findViewById(R.id.designPaintButton);
        dininigRoom=(Button)findViewById(R.id.diningRoomButton);
        jypsum=(Button)findViewById(R.id.jypsumButton);
        kidRoom=(Button)findViewById(R.id.kidRoomButton);
        kitchen=(Button)findViewById(R.id.kithchenButton);
        duplexStair=(Button)findViewById(R.id.duplexStarButton);
        mainDoor=(Button)findViewById(R.id.mainDoorButton);
        readingDressing=(Button)findViewById(R.id.readingDressingButton);
        wallCabinet=(Button)findViewById(R.id.wallCabinetButton);
        furniture=(Button)findViewById(R.id.buttonFurniture);
        wallTv=(Button)findViewById(R.id.wallTvButton);
        drawingRoom=(Button)findViewById(R.id.drawingRoomButton);
        livingRoom=(Button)findViewById(R.id.livingRoomButton);
        conventionHall=(Button)findViewById(R.id.conventionalButton);
        SwimingPool=(Button)findViewById(R.id.swimingPoolButton);
       resort=(Button)findViewById(R.id.resortButton);
        office=(Button)findViewById(R.id.officeButton);
        project=(Button)findViewById(R.id.projectButton);
        contact=(Button)findViewById(R.id.contactButton);
        ourClients=(Button)findViewById(R.id.clientButton);
        aboutUs=(Button)findViewById(R.id.aboutButton);

    }


    public void onClick(View v){

        if(v.getId()==R.id.bedRoomButton){
            url="bed.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.windowButton){
            url="window.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.designGlassButton){
            url="design_glass.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.designPaintButton){
            url="design_paint.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.diningRoomButton){
            url="dining_room.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.jypsumButton){
            url="jypsum.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.kidRoomButton){
            url="kids_room.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.kithchenButton){
            url="kitchen.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.duplexStarButton){
            url="duplex_stair.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.mainDoorButton){
            url="main_door.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.readingDressingButton){
            url="reading&dress.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.wallCabinetButton){
            url="wallcabinet.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.buttonFurniture){

            Intent mainIntent=new Intent(HomeActivity.this,Furniture.class);

            startActivity(mainIntent);
        }
        if(v.getId()==R.id.wallTvButton){
            url="tv_wall.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.drawingRoomButton){
            url="drawing_room.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.livingRoomButton){
            url="living_room.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.conventionalButton){
            url="convention_hall.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.swimingPoolButton){
            url="swiming_pool.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.resortButton){
            url="resort.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.officeButton){
            url="office.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.contactButton){
            url="office.php";
            Intent mainIntent=new Intent(HomeActivity.this,ContactDetails.class);
          //  mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.projectButton){

            Intent mainIntent=new Intent(HomeActivity.this,p1.class);

            startActivity(mainIntent);
        }
        if(v.getId()==R.id.clientButton){
            url="client.php";
            Intent mainIntent=new Intent(HomeActivity.this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if(v.getId()==R.id.aboutButton){

            Intent mainIntent=new Intent(HomeActivity.this,AboutUs.class);
            startActivity(mainIntent);
        }
    }
}
