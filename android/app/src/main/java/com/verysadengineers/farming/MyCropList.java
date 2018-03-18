package com.verysadengineers.farming;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
        View gridViewItem = layoutInflater.inflate(R.layout.grid_layout_mycrop, null, true);

        ImageView imageViewItem = gridViewItem.findViewById(R.id.imageViewItem);

        Crop crop = myCrops.get(position);

        Bitmap bitmap = getBitmapFromURL(crop.getImageURL());

        imageViewItem.setImageBitmap(bitmap);

        TextView textViewHarvest = gridViewItem.findViewById(R.id.textViewHarvest);
        TextView textViewWater = gridViewItem.findViewById(R.id.textViewWater);

        textViewHarvest.setText("Harvest within "+crop.getHarvestTime()+" days");
        textViewWater.setText("Needs watering within "+crop.getWaterTimer()+" hours");

        return gridViewItem;
    }

    public Bitmap getBitmapFromURL(String src){
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;

        } catch (Exception e) {
            e.printStackTrace();;
            return null;
        }
    }
}
/*
        LayoutInflater layoutInflater = context.getLayoutInflater();

        @SuppressLint("ViewHolder")
        View gridViewItem = layoutInflater.inflate(R.layout.grid_layout_mycrop, null, true);

        ImageView imageViewItem = gridViewItem.findViewById(R.id.imageViewItem);

        Crop crop = crops.get(position);

        Bitmap bitmap = getBitmapFromURL(crop.getImageURL());

        imageViewItem.setImageBitmap(bitmap);

        return gridViewItem;
    }

    public Bitmap getBitmapFromURL(String src){
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;

        } catch (Exception e) {
            e.printStackTrace();;
            return null;
        }
    }
 */