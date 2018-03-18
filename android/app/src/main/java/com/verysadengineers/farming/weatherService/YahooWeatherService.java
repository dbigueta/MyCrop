package com.verysadengineers.farming.weatherService;
import android.os.AsyncTask;
/**
 * Created by Alvin on 2018-03-17.
 */

public class YahooWeatherService {
    private WeatherServiceCallBack callback;
    private String location;

    public YahooWeatherService(WeatherServiceCallBack callback) {
        this.callback = callback;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void refreshWeather(String location){
        new AsyncTask<String, Void, String>(){
            @Override
            protected String doInBackground(String... strings){
                return null;
            }
            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
            }
        }.execute(location);
    }
}
