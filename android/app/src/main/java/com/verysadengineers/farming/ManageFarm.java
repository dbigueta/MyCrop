package com.verysadengineers.farming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 2018-03-18.
 */

public class ManageFarm extends AppCompatActivity {


    private DatabaseReference databaseMyCrop;
    private List<Crop> myCrops;
    private GridView listViewCrops;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_farm);

        myCrops = new ArrayList<>();
        databaseMyCrop = FirebaseDatabase.getInstance().getReference("mycrop");
        listViewCrops = findViewById(R.id.listViewMyCrops);

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseMyCrop.addListenerForSingleValueEvent(new ValueEventListener(){

            Crop crop = (Crop) getIntent().getSerializableExtra("crop");
            public void onDataChange(DataSnapshot dataSnapshot){
                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                    Crop tempCrop = itemSnapshot.getValue(Crop.class);
                    myCrops.add(tempCrop);
                }

                MyCropList adapter = new MyCropList(ManageFarm.this, myCrops);
                listViewCrops.setAdapter(adapter);
            }
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    public void newCrop(View v) {
        Intent intentNewCrop = new Intent(this, SelectClimate.class);
        startActivity(intentNewCrop);
    }
}