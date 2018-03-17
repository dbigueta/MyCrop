package com.verysadengineers.farming.weatherService;

import com.verysadengineers.farming.weatherData.Channel;
/**
 * Created by Alvin on 2018-03-17.
 */

public interface WeatherServiceCallBack {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);

}
