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

public class ClimateList extends ArrayAdapter<String> {
    private Activity context;
    private List<String> climates = new ArrayList<>();

    public ClimateList(Activity context, List<String> climates){
        super(context, R.layout.list_items, climates);
        this.context = context;
        this.climates = climates;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();

        @SuppressLint("ViewHolder")
        View listViewItem = layoutInflater.inflate(R.layout.list_items, null, true);

        TextView textViewName = listViewItem.findViewById(R.id.textViewName);

        String climate = climates.get(position);

        textViewName.setText(climate);

        return listViewItem;
    }
}
