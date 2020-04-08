package com.winnieweather.example.i_weather.di

import com.winnieweather.example.i_weather.WeatherApi
import com.winnieweather.example.i_weather.WeatherRepository
import com.winnieweather.example.small_test_utils.di.scope.PerTest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class WeatherApiTestModule {

    @PerTest
    @Provides
    fun provideWeatherApi(retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }

    @Provides
    @PerTest
    internal fun provideWeatherRepository(weatherApi: WeatherApi): WeatherRepository {
        return WeatherRepository(weatherApi)
    }
}