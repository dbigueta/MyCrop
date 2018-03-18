package com.verysadengineers.farming;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SelectClimate extends AppCompatActivity {

    private GridView gridViewClimates; //The list itself
    private DatabaseReference databaseClimates;
    private List<String> climates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_climate);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        databaseClimates = FirebaseDatabase.getInstance().getReference("climates");
        climates = new ArrayList<>();

        gridViewClimates = findViewById(R.id.gridViewClimates);

        gridViewClimates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(v.getContext(), SelectSeason.class);
                intent.putExtra("climate", climates.get(position));
                climates.get(position);

                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseClimates.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                climates.clear();
                for(DataSnapshot itemSnapshot: dataSnapshot.getChildren()){
                    String climate = itemSnapshot.getValue(String.class);
                    climates.add(climate);
                }

                ClimateList adapter = new ClimateList(SelectClimate.this, climates);
                gridViewClimates.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Failed to read");
            }
        });
    }

    /*public void sendMessage(View view) {
        Intent startNewActivity = new Intent(this, SelectCrop.class);
        startActivity(startNewActivity);
    }*/

}

