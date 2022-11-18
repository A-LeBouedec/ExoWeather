package com.example.exoweather.feature.weather.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.exoweather.feature.weather.presentation.component.ProgressBar

@Composable
fun WeatherScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TODO
        Text(text = "texte")
        ProgressBar(
            progress = 0.4f,
            title = "Discussion avec votre banquier météorologue, pas commode"
        )
    }
}
