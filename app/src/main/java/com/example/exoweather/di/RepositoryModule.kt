package com.example.exoweather.di

import com.example.exoweather.feature.weather.data.repository.WeatherRepositoryImp
import com.example.exoweather.feature.weather.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        weatherRepositoryImp: WeatherRepositoryImp
    ): WeatherRepository
}