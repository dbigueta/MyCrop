package com.verysadengineers.farming;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 2018-03-17.
 */

public class CropList extends ArrayAdapter<Crop> {
    private Activity context;
    private List<Crop> crops = new ArrayList<>(); //how to make this an array?

    public CropList(Activity context, List<Crop> crops){
        super(context, R.layout.grid_layout, crops);
        this.context = context;
        this.crops = crops;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();

        @SuppressLint("ViewHolder")
        View gridViewItem = layoutInflater.inflate(R.layout.grid_layout, null, true);

        TextView textViewItem = gridViewItem.findViewById(R.id.textViewItem);

        Crop crop = crops.get(position);

        textViewItem.setText(crop.getName());

        return gridViewItem;
    }
}

