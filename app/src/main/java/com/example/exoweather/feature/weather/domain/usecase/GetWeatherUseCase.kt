package com.example.exoweather.feature.weather.domain.usecase

import com.example.exoweather.common.domain.util.Response
import com.example.exoweather.feature.weather.domain.model.Weather
import com.example.exoweather.feature.weather.domain.repository.WeatherRepository

class GetWeatherUseCase(
    private val repository: WeatherRepository
) {

    suspend fun execute(city: String): Response<Weather> {
        return repository.getWeather(city)
    }
}
