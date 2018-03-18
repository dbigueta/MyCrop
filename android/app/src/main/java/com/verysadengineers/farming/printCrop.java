package com.verysadengineers.farming;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alvin on 2018-03-17.
 */

public class printCrop extends AppCompatActivity {

    private TextView cropName;
    private TextView cropHarvest;
    private TextView cropWatering;
    private ListView cropClimates;
    private ListView cropSeasons;

    private Button addButton;

    private List<String> listClimates;
    private List<String> listSeasons;

    private TextView bio;

    private DatabaseReference databaseDescription;
    private DatabaseReference databaseMyCrop;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_crop);
        final Crop crop = (Crop) getIntent().getSerializableExtra("crop");
        databaseDescription = FirebaseDatabase.getInstance().getReference("description");
        databaseDescription = FirebaseDatabase.getInstance().getReference("mycrop");

        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addCrop(crop);
            }

        });

        cropName = (TextView) findViewById(R.id.nameText);
        cropName.setText(crop.getName());

        cropHarvest = (TextView) findViewById(R.id.harvestText);
        cropHarvest.setText(""+ crop.getHarvestTime() +" days to grow");

        cropWatering = (TextView) findViewById(R.id.wateringText);
        cropWatering.setText("Water every "+ crop.getWaterTimer() +" hours");

        cropClimates = findViewById(R.id.climatesText);
        cropSeasons = findViewById(R.id.seasonsText);

        listClimates = new ArrayList<>();
        listSeasons = new ArrayList<>();

        for(String temp: crop.getClimate()){
            String climate = temp;
            listClimates.add(climate);
        }
        for(String temp: crop.getSeason()){
            String season = temp;
            listSeasons.add(season);
        }
        ClimateList climateAdapter = new ClimateList(printCrop.this, listClimates);
        final ArrayAdapter<String> seasonAdapter = new ArrayAdapter<>( this, android.R.layout.simple_list_item_1, listSeasons);
        cropClimates.setAdapter(climateAdapter);
        cropSeasons.setAdapter(seasonAdapter);


    }
    private void addCrop(Crop crop){
        String id = databaseMyCrop.push().getKey();
        Crop newCrop = new Crop( crop.getName(), crop.getSeason(), crop.getClimate(), crop.getHarvestTime(), crop.getImageURL());
        databaseMyCrop.child(id).setValue(newCrop);
    }
}
