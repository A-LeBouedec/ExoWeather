package com.example.exoweather.feature.weather.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.exoweather.R
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
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://openweathermap.org/img/w/${cityWeather.weatherIcon}.png")
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentDescription = cityWeather.weatherDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(50.dp)
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
        ) {
            Text(text = cityWeather.cityName)
            Text(text = cityWeather.temperature)
        }
    }
}
