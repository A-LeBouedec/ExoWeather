package com.example.exoweather.feature.weather.data.remote.dto

data class SysDto(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)