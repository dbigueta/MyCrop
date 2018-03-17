package com.verysadengineers.farming;

import java.util.List;

/**
 * Created by Alvin on 2018-03-17.
 */

public class Crop {
    private String name;
    private List<String> season;
    private List<String> climate;
    private int waterTimer; //arbitiary
    private int currentTimeAlive = 0;
    private int harvestTime;

    public Crop() {}
    public Crop(String name, List<String> season, List<String> climate, int harvestTime){
        this.name = name;
        this.season = season;
        this.climate = climate;
        this.harvestTime = harvestTime;
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
}
