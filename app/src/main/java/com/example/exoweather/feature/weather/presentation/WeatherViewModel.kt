package com.example.exoweather.feature.weather.presentation

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exoweather.feature.weather.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // State
    ///////////////////////////////////////////////////////////////////////////

    var state by mutableStateOf(WeatherState())
        private set

    ///////////////////////////////////////////////////////////////////////////
    // Data
    ///////////////////////////////////////////////////////////////////////////

    private var timer = object : CountDownTimer(SIXTY_SECONDS_IN_MILLIS, ONE_SECOND_IN_MILLIS) {
        override fun onTick(millisUntilFinished: Long) {
            // Set progress
            val currentProgress = (60000f - millisUntilFinished.toFloat()) / 60000f
            state = state.copy(
                isLoading = true,
                progress = currentProgress
            )
        }

        override fun onFinish() {
            state = state.copy(
                isLoading = false,
                progress = 1f
            )
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Init
    ///////////////////////////////////////////////////////////////////////////

    init {
        startProgress()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Public Functions
    ///////////////////////////////////////////////////////////////////////////

    fun startProgress() {
        viewModelScope.launch {
            timer.start()
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private Functions
    ///////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    // Companion Object
    ///////////////////////////////////////////////////////////////////////////

    companion object {
        private const val SIXTY_SECONDS_IN_MILLIS = 60000L
        private const val ONE_SECOND_IN_MILLIS = 1000L
    }
}
