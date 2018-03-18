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

public class SeasonList extends ArrayAdapter<String> {
    private Activity context;
    private List<String> seasons = new ArrayList<>();

    public SeasonList(Activity context, List<String> seasons){
        super(context, R.layout.grid_layout_climate);
        this.context = context;
        this.seasons = seasons;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();

        @SuppressLint("ViewHolder")
        View gridViewItem = layoutInflater.inflate(R.layout.grid_layout_season, null, true);

        TextView textViewItem = gridViewItem.findViewById(R.id.textViewItem);

        String season = seasons.get(position);

        textViewItem.setText(season);

        return gridViewItem;
    }
}
