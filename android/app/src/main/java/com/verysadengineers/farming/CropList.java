package com.verysadengineers.farming;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 2018-03-17.
 */

public class CropList extends ArrayAdapter<Crop> {
    private Activity context;
    private List<Crop> crops = new ArrayList<>(); //how to make this an array?
    private Bitmap bitmap;

    public CropList(Activity context, List<Crop> crops){
        super(context, R.layout.grid_layout_climate, crops);
        this.context = context;
        this.crops = crops;
        //bitmap = getBitmapFromURL("https://firebasestorage.googleapis.com/v0/b/missionhacks-project.appspot.com/o/Watermelon.jpg?alt=media&token=49e8b442-6316-43ce-8592-39f65f0b5d5d");
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();

        @SuppressLint("ViewHolder")
        View gridViewItem = layoutInflater.inflate(R.layout.grid_layout_crop, null, true);

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

}

