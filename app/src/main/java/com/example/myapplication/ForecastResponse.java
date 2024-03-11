package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastResponse {

    @SerializedName("list")
    private List<ForecastItem> forecastItems;

    public List<ForecastItem> getForecastItems() {
        return forecastItems;
    }
}
