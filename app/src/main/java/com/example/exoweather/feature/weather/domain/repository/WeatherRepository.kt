package com.example.exoweather.feature.weather.domain.repository

import com.example.exoweather.feature.weather.domain.model.Weather

interface WeatherRepository {
    suspend fun getWeather(city: String): Weather
}
