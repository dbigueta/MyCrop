package com.verysadengineers.farming;

import android.widget.ListView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alvin on 2018-03-17.
 */

public class Crop implements Serializable{
    private String name;
    private List<String> season;
    private List<String> climate;
    private String tips;
    private List<String> pests;
    private List<String> dishes;
    private int waterTimer; //arbitiary
    private int currentTimeAlive = 0;
    private int harvestTime;
    private String imageURL;

    public Crop() {}
    public Crop(String name, List<String> season, List<String> climate, String tips, List<String> pests, List<String> dishes, int harvestTime, String imageURL){
        this.name = name;
        this.season = season;
        this.climate = climate;
        this.tips = tips;
        this.pests = pests;
        this.dishes = dishes;
        this.harvestTime = harvestTime;
        this.imageURL = imageURL;
    }



    public String getName() {
        return name;
    }

    public String getTips() {
        return tips;
    }

    public List<String> getPests() {
        return pests;
    }

    public List<String> getDishes() {
        return dishes;
    }

    public int getCurrentTimeAlive() {
        return currentTimeAlive;
    }

    public List<String> getSeason() {
        return season;
    }

    public List<String> getClimate() {
        return climate;
    }

    public int getWaterTimer() {
        return waterTimer;
    }

    public int getHarvestTime() {
        return harvestTime;
    }

    public String getImageURL() { return imageURL; }
}
