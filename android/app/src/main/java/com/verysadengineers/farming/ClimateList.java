package com.verysadengineers.farming;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
        super(context, R.layout.grid_layout_climate, climates);
        this.context = context;
        this.climates = climates;
    }

    @Override
    public int getCount(){
        return climates.size();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();

        @SuppressLint("ViewHolder")
        View gridViewItem = layoutInflater.inflate(R.layout.grid_layout_climate, null, true);

        ImageView imageViewItem = gridViewItem.findViewById(R.id.imageViewItem);

        String climate = climates.get(position);
        Drawable image = null;

        if(climate.equals("Coastal")) {
            image = context.getDrawable(R.drawable.coastal);
        }
        else if (climate.equals("Desert")) {
            image = context.getDrawable(R.drawable.desert);
        }
        else if (climate.equals("Mediterranean")) {
            image = context.getDrawable(R.drawable.mediterranean);
        }
        else if (climate.equals("Tropical")) {
            image = context.getDrawable(R.drawable.tropical);
        }
        imageViewItem.setImageDrawable(image);

        return gridViewItem;
    }
}
