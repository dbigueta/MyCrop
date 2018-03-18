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
import android.widget.ListView;

import java.util.List;

/**
 * Created by Ali on 2018-03-18.
 */

public class MyCropList extends ArrayAdapter<Crop> {

    private Activity context;
    private List<Crop> myCrops;

    public MyCropList(Activity context, List<Crop> myCrops){
        super(context, R.layout.grid_layout_season);
        this.context = context;
        this.myCrops = myCrops;
    }



    @Override
    public int getCount(){
        return myCrops.size();
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
        View listViewItem = layoutInflater.inflate(R.layout.grid_layout_mycrop, null, true);

        Crop crop = myCrops.get(position);

        return listViewItem;
    }
}
