package com.example.exoweather.feature.weather.data.remote.api

import com.example.exoweather.feature.weather.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {

    @GET("weather?")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): WeatherDto
}