package com.example.exoweather.feature.weather.data.remote.dto

import com.squareup.moshi.Json

data class MainDto(
    @field:Json(name = "feels_like")
    val feelsLike: Double,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    @field:Json(name = "temp_max")
    val tempMax: Double,
    @field:Json(name = "temp_min")
    val tempMin: Double
)