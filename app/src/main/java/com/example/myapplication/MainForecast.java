package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class MainForecast {
    @SerializedName("temp")
    private double temp;

    public double getTemp() {
        return temp;
    }
}


