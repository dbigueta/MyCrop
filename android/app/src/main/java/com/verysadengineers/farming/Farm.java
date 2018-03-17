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
 * Created by Alvin on 2018-03-17.
 */

public class Farm extends ArrayAdapter<Crop>{
    private Activity context;
    private List<Crop> crops = new ArrayList<>(); //how to make this an array?

    public Farm(Activity context, List<Crop> crops){
        super(context, R.layout.crop_list, crops);
        this.context = context;
        this.crops = crops;
    }

    /*insert methods*/
    //access crop info (use getFunctions)
    //reset water timer -- alter a second database?
    //add to cropArray
    public void addCrop(Crop crop){
        crops.add(crop);
    }
    //remove from cropArray

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();

        @SuppressLint("ViewHolder")
        View listViewItem = layoutInflater.inflate(R.layout.crop_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);

        Crop crop = crops.get(position);
        System.out.println(crop.getName());
        textViewName.setText(crop.getName());

        return listViewItem;
    }
}
