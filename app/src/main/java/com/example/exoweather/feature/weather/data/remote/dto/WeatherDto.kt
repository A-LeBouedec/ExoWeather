package com.example.exoweather.feature.weather.data.remote.dto

import com.example.exoweather.feature.weather.domain.model.Weather

data class WeatherDto(
    val base: String,
    val cloudsDto: CloudsDto,
    val cod: Int,
    val coordDto: CoordDto,
    val dt: Int,
    val id: Int,
    val main: MainDto,
    val name: String,
    val sys: SysDto,
    val timezone: Int,
    val visibility: Int,
    val weather: List<WeatherDataDto>,
    val wind: WindDto
) {
    fun toWeather(): Weather {
        return Weather(
            cityName = name,
            temperature = main.temp,
            weatherDescription = weather.first().description,
            weatherIcon = weather.first().icon
        )
    }
}
