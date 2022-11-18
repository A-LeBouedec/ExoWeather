package com.example.exoweather.feature.weather.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.exoweather.feature.weather.presentation.component.ProgressBar

@Composable
fun WeatherScreen(
    navController: NavController,
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TODO
        Text(text = "texte")

        if (state.isLoading) {
            ProgressBar(
                progress = state.progress,
                title = "Discussion avec votre banquier météorologue, pas commode"
            )
        } else {
            Button(onClick = { viewModel.startProgress() }) {
                Text(text = "recommencer")
            }
        }
    }
}
