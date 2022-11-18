package com.example.exoweather.feature.weather.presentation

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exoweather.common.domain.util.Response
import com.example.exoweather.feature.weather.domain.model.Weather
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

    private val weathers = mutableListOf<Weather>()
    private val loadingMessages = listOf(
        "NOus téléchargeons les données...",
        "C'est presque fini...",
        "Plus que quelques secondes avant d'avoir le résultat..."
    )

    private var tick: Int = 0
    private var loadingMessageIndex: Int = 0
    private var timer = object : CountDownTimer(SIXTY_SECONDS_IN_MILLIS, ONE_SECOND_IN_MILLIS) {
        override fun onTick(millisUntilFinished: Long) {
            // Set progress
            val currentProgress = (60000f - millisUntilFinished.toFloat()) / 60000f
            state = state.copy(
                isLoading = true,
                progress = currentProgress
            )

            // Display Loading Message
            if (tick % 6 == 0) {
                state = state.copy(loadingMessage = loadingMessages[loadingMessageIndex % 3])
                loadingMessageIndex++
            }

            // Load Weather
            when (tick) {
                0 -> loadWeather("Rennes")
                10 -> loadWeather("Paris")
                20 -> loadWeather("Nantes")
                30 -> loadWeather("Bordeaux")
                40 -> loadWeather("Lyon")
            }
            tick++
        }

        override fun onFinish() {
            tick = 0
            loadingMessageIndex = 0
            state = state.copy(
                weathers = weathers,
                isLoading = false,
                errorMessage = null,
                progress = 1f
            )
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // LifeCycle
    ///////////////////////////////////////////////////////////////////////////

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
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
            resetData()
            timer.start()
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private Functions
    ///////////////////////////////////////////////////////////////////////////

    private fun loadWeather(city: String) {
        viewModelScope.launch {
            when (val result = getWeatherUseCase.execute(city)) {
                is Response.Success -> {
                    result.data?.let { weathers.add(it) }
                }
                is Response.Error -> {
                    resetData()
                    state = state.copy(
                        weathers = weathers,
                        isLoading = false,
                        errorMessage = result.message,
                        progress = 0f
                    )
                }
            }
        }
    }

    private fun resetData() {
        timer.cancel()
        tick = 0
        weathers.clear()
        loadingMessageIndex = 0
    }

    ///////////////////////////////////////////////////////////////////////////
    // Companion Object
    ///////////////////////////////////////////////////////////////////////////

    companion object {
        private const val SIXTY_SECONDS_IN_MILLIS = 60000L
        private const val ONE_SECOND_IN_MILLIS = 1000L
    }
}
