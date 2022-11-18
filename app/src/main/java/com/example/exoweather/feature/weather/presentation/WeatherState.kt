package com.example.exoweather.feature.weather.presentation

import com.example.exoweather.feature.weather.domain.model.Weather

data class WeatherState(
    val weathers: List<Weather> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val progress: Float = 0f
)
