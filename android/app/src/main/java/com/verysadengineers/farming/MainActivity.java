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
    private List<Crop> crops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseCrops = FirebaseDatabase.getInstance().getReference("crop");
        /*databaseWeather = apidatabase.getinstance.getreference("name of thing");*/
        crops = new ArrayList<>();

        gridViewItems = findViewById(R.id.gridViewItems);

    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseCrops.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                crops.clear();
                for(DataSnapshot cropSnapshot: dataSnapshot.getChildren()){
                    Crop crop = cropSnapshot.getValue(Crop.class);
                    crops.add(crop);
                }

                CropList cropsAdapter = new CropList(MainActivity.this, crops);
                gridViewItems.setAdapter(cropsAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Failed to read");
            }
        });
    }
}
