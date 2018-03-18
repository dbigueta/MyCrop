package com.verysadengineers.farming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 2018-03-17.
 */

public class SelectSeason extends AppCompatActivity{


        private GridView gridViewSeasons; //The list itself

        private List<String> seasons = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_select_season);

            seasons.add("Fall");

            seasons.add("Spring");

            gridViewSeasons = findViewById(R.id.gridViewSeasons);

            SeasonList adapter = new SeasonList(SelectSeason.this, seasons);
            gridViewSeasons.setAdapter(adapter);

            gridViewSeasons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {
                    Intent intent = new Intent(v.getContext(), SelectCrop.class);
                    Bundle bundle = getIntent().getExtras();

                    intent.putExtra("climate", (String) bundle.get("climate"));
                    intent.putExtra("season", seasons.get(position));

                    seasons.get(position);
                    startActivity(intent);
                }
            });

        }

    }


