package com.verysadengineers.farming;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 2018-03-17.
 */

public class ClimateList extends ArrayAdapter<String> {
    private Activity context;
    private List<String> climates = new ArrayList<>();

    public ClimateList(Activity context, List<String> climates){
        super(context, R.layout.grid_layout, climates);
        this.context = context;
        this.climates = climates;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();

        @SuppressLint("ViewHolder")
        View gridViewItem = layoutInflater.inflate(R.layout.grid_layout, null, true);

        TextView textViewItem = gridViewItem.findViewById(R.id.textViewItem);

        String climate = climates.get(position);

        textViewItem.setText(climate);

        return gridViewItem;
    }
}
