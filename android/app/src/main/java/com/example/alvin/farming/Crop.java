package com.example.alvin.farming;

/**
 * Created by Alvin on 2018-03-17.
 */

public class Crop {
    String name;
    String season;
    String climate;
    int waterTimer; //arbitiary
    int harvestTimer;

    public Crop() {}
    public Crop(String name, String season, String climate, int waterTimer, int harvestTimer){
        this.name = name;
        this.season = season;
        this.climate = climate;
        this.waterTimer = waterTimer;
        this.harvestTimer = harvestTimer;
    }

    public String getName() {
        return name;
    }

    public String getSeason() {
        return season;
    }

    public String getClimate() {
        return climate;
    }

    public int getWaterTimer() {
        return waterTimer;
    }

    public int getHarvestTimer() {
        return harvestTimer;
    }
}
