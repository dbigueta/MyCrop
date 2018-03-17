package com.verysadengineers.farming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridViewItems; //The list itself
    private DatabaseReference databaseCrops;
    private DatabaseReference databaseWeather;
    private DatabaseReference databaseClimates;
    private List<Crop> crops;
    private List<String> climates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseCrops = FirebaseDatabase.getInstance().getReference("crops");
        databaseClimates = FirebaseDatabase.getInstance().getReference("climates");
        /*databaseWeather = apidatabase.getinstance.getreference("name of thing");*/
        crops = new ArrayList<>();
        climates = new ArrayList<>();

        gridViewItems = findViewById(R.id.gridViewItems);

    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseClimates.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                climates.clear();
                for(DataSnapshot itemSnapshot: dataSnapshot.getChildren()){
                    String climate = itemSnapshot.getValue(String.class);
                    climates.add(climate);
                }

                ClimateList adapter = new ClimateList(MainActivity.this, climates);
                gridViewItems.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Failed to read");
            }
        });
    }
}

