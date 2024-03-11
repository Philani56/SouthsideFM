package com.example.myapplication


class WeatherResponse {
    val main: Main? = null
    val weather: List<Weather>? = null
    val icon: String? = null // Add this field

    // Other methods...
    class Main {
        val temp = 0.0
    }

    class Weather {
        val description: String? = null
    }
}






