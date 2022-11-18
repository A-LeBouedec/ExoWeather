package com.example.exoweather.feature.weather.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.exoweather.feature.weather.presentation.component.CityWeatherItem
import com.example.exoweather.feature.weather.presentation.component.ProgressBar

@Composable
fun WeatherScreen(
    navController: NavController, // For a next feature, like cityWeatherDetail
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.isLoading) {
            // Loading Message
            Text(
                text = state.loadingMessage,
                textAlign = TextAlign.Center
            )
            // ProgressBar
            ProgressBar(
                progress = state.progress,
                title = "Discussion avec votre banquier météorologue, pas commode"
            )
        } else {
            if (state.errorMessage != null) {
                // Error Message
                Text(
                    text = state.errorMessage,
                    textAlign = TextAlign.Center,
                    color = Color.Red
                )
            } else {
                // City Weather list
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    items(state.weathers) { cityWeather ->
                        CityWeatherItem(cityWeather = cityWeather)
                        Divider()
                    }
                }
            }
            // Try again button
            Button(onClick = { viewModel.startProgress() }) {
                Text(text = "recommencer")
            }
        }
    }
}
