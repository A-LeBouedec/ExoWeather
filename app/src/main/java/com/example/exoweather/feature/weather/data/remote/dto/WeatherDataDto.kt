package com.example.exoweather.feature.weather.data.remote.dto

data class WeatherDataDto(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)