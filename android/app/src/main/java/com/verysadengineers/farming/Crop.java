package com.verysadengineers.farming;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alvin on 2018-03-17.
 */

public class Crop implements Serializable{
    private String name;
    private List<String> season;
    private List<String> climate;
    private int waterTimer; //arbitiary
    private int currentTimeAlive = 0;
    private int harvestTime;
    private String imageURL;

    public Crop() {}
    public Crop(String name, List<String> season, List<String> climate, int harvestTime, String imageURL){
        this.name = name;
        this.season = season;
        this.climate = climate;
        this.harvestTime = harvestTime;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
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
