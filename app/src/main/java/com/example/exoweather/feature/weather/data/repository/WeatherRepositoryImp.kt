package com.example.exoweather.feature.weather.data.repository

import com.example.exoweather.BuildConfig
import com.example.exoweather.common.domain.util.Response
import com.example.exoweather.feature.weather.data.remote.api.OpenWeatherApi
import com.example.exoweather.feature.weather.domain.model.Weather
import com.example.exoweather.feature.weather.domain.repository.WeatherRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    private val api: OpenWeatherApi
) : WeatherRepository {

    override suspend fun getWeather(city: String): Response<Weather> {
        val apiKey = BuildConfig.OPEN_WEATHER_API_KEY
        return if (apiKey == "") {
            Response.Error("Enter your API key, Follow the instruction in the ReadMe.md")
        } else {
            try {
                Response.Success(data = api.getWeather(city, apiKey).toWeather())
            } catch (e: HttpException) {
                Response.Error(e.localizedMessage ?: "Something went wrong, try again")
            } catch (e: IOException) {
                Response.Error("Check your internet connexion")
            }
        }
    }
}
