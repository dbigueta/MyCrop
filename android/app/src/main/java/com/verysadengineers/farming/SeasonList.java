package com.verysadengineers.farming;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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

public class SeasonList extends ArrayAdapter<String> {
    private Activity context;
    private List<String> seasons = new ArrayList<>();

    public SeasonList(Activity context, List<String> seasons){
        super(context, R.layout.grid_layout_season);
        this.context = context;
        this.seasons = seasons;
    }


    @Override
    public int getCount(){
        return seasons.size();
    }

    /*@Override
    public long getItemId(int arg0) {
        return seasons.get(arg0);
    }*/

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();

        @SuppressLint("ViewHolder")
        View gridViewItem = layoutInflater.inflate(R.layout.grid_layout_season, null, true);

        ImageView imageViewItem= gridViewItem.findViewById(R.id.imageViewItem);

        String season = seasons.get(position);
        Drawable image = null;

        if(season.equals("Fall"))
            image = context.getDrawable(R.drawable.fall);
        else if (season.equals("Spring"))
            image = context.getDrawable(R.drawable.spring);

        imageViewItem.setImageDrawable(image);

        return gridViewItem;
    }
}
