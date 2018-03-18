package com.verysadengineers.farming;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * Created by Alvin on 2018-03-17.
 */

public class printCrop extends AppCompatActivity {

    private String cropName;
    private List<String> cropClimate;
    private List<String> cropSeason;
    private int cropHarvest;
    private DatabaseReference databaseCrops;
    private ListView listViewCrops;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_crop);
        //listViewCrops = (ListView) findViewById(R.id.listViewCrop);
        Crop crop = (Crop) getIntent().getSerializableExtra("crop");
        cropName = crop.getName();
        cropClimate = crop.getClimate();
        cropSeason = crop.getSeason();
        cropHarvest = crop.getHarvestTime();



    }

}
