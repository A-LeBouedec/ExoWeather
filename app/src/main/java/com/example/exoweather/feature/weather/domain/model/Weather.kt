package com.example.exoweather.feature.weather.domain.model

data class Weather(
    val cityName: String,
    val temperature: String,
    val weatherDescription: String,
    val weatherIcon: String
)
