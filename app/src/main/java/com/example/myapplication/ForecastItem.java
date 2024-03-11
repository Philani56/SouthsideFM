package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ForecastItem {
    @SerializedName("dt")
    private long dateTime;

    @SerializedName("main")
    private MainForecast mainForecast;

    @SerializedName("weather")
    private List<Weather> weatherList;

    public long getDateTime() {
        return dateTime;
    }

    public MainForecast getMainForecast() {
        return mainForecast;
    }

    public List<Weather> getWeathersList() {
        return weatherList;
    }
}
