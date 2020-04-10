package com.winnieweather.example.application.weather.di

import com.winnieweather.example.i_weather.WeatherApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.surfstudio.android.dagger.scope.PerApplication

@Module
class WeatherModule {

    @Provides
    @PerApplication
    fun provideWeatherApi(retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }
}