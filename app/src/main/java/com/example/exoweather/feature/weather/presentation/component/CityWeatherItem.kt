package com.example.exoweather.feature.weather.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.exoweather.feature.weather.domain.model.Weather

@Composable
fun CityWeatherItem(
    modifier: Modifier = Modifier,
    cityWeather: Weather
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(text = cityWeather.weatherDescription)
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
        ) {
            Text(text = cityWeather.cityName)
            Text(text = cityWeather.temperature.toString())
        }
    }

}