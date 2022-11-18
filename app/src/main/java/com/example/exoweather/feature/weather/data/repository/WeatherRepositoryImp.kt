package com.example.exoweather.feature.weather.data.repository

import com.example.exoweather.feature.weather.data.remote.api.OpenWeatherApi
import com.example.exoweather.feature.weather.domain.model.Weather
import com.example.exoweather.feature.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    private val api: OpenWeatherApi
) : WeatherRepository {

    override suspend fun getWeather(city: String): Weather {
        // TODO
        val apiKey = ""
        return api.getWeather(city, apiKey).toWeather()
    }
}
