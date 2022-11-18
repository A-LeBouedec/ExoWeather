package com.example.exoweather.common.presentation.screen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Weather : Screen("weather")
}
