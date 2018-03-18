package com.verysadengineers.farming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Ali on 2018-03-18.
 */

public class ManageFarm extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_farm);
    }

    public void newCrop(View v) {
        Intent intentNewCrop = new Intent(this, SelectClimate.class);
        startActivity(intentNewCrop);
    }
}