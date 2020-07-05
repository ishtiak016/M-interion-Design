package com.example.motherinterior;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Furniture extends AppCompatActivity {
    Button bed, chair, diningTable, showpiceces, waredrove,sofa,office,kithcen;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture);
        bed = (Button) findViewById(R.id.bedButton);
        chair = (Button) findViewById(R.id.chairButton);
        diningTable = (Button) findViewById(R.id.diningTableButton);
        showpiceces = (Button) findViewById(R.id.showpiecesButton);
        waredrove = (Button) findViewById(R.id.wareDroveButton);
        sofa=(Button)findViewById(R.id.sofaButton);
        kithcen=(Button)findViewById(R.id.kitchenButton);

    }

    public void onClick(View v) {

        if (v.getId() == R.id.bedButton) {
            url="bed_furniture.php";
            Intent mainIntent=new Intent(this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if (v.getId() == R.id.chairButton) {
            url="chair_furniture.php";
            Intent mainIntent=new Intent(this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if (v.getId() == R.id.diningTableButton) {
            url="dining_furniture.php";
            Intent mainIntent=new Intent(this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if (v.getId() == R.id.showpiecesButton) {
            url="showpeas_furniture.php";
            Intent mainIntent=new Intent(this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if (v.getId() == R.id.wareDroveButton) {
            url="waredrobe_furniture.php";
            Intent mainIntent=new Intent(this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if (v.getId() == R.id.sofaButton) {
            url="sofa_furniture.php";
            Intent mainIntent=new Intent(this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if (v.getId() == R.id.kitchenButton) {
            url="kitchen_furniture.php";
            Intent mainIntent=new Intent(this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }
        if (v.getId() == R.id.officeButton) {
            url="office_furniture.php";
            Intent mainIntent=new Intent(this,Main2Activity.class);
            mainIntent.putExtra("message", url);
            startActivity(mainIntent);
        }

    }
}