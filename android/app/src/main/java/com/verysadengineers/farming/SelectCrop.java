package com.verysadengineers.farming;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 2018-03-17.
 */

public class SelectCrop extends AppCompatActivity {

    private GridView gridViewCrops; //The list itself
    private DatabaseReference databaseCrops;
    private List<Crop> crops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_crop);

        databaseCrops = FirebaseDatabase.getInstance().getReference("crop");
        crops = new ArrayList<>();
        gridViewCrops = findViewById(R.id.gridViewCrops);
        gridViewCrops.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(v.getContext(), printCrop.class);
                intent.putExtra("crop", crops.get(position));
                crops.get(position);

                startActivity(intent);
            }
        });
        }


    @Override
    protected void onStart() {
        super.onStart();
        databaseCrops.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Bundle bundle = getIntent().getExtras();
                crops.clear();
                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                    Crop crop = itemSnapshot.getValue(Crop.class);
                    System.out.println(crop.getClimate().get(0) + " " + bundle.get("climate") + crop.getSeason().get(0) + " " + bundle.get("season"));
                    if((crop.getClimate().contains(bundle.get("climate"))) && (crop.getSeason().contains(bundle.get("season")))) {
                        crops.add(crop);
                    }
                }

                CropList adapter = new CropList(SelectCrop.this, crops);
                gridViewCrops.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Failed to read");
            }
        });


    }


}
