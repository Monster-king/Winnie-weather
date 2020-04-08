package com.winnieweather.example.i_weather

import com.winnieweather.example.i_network.WeatherUrl
import com.winnieweather.example.i_weather.response.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Апи погоды
 */
interface WeatherApi {

    /**
     * Возвращает текущую информацию погоды по заданной геолокации
     *
     * @param lat широта (latitude) местоположения
     * @param lon долгота (longitude) местоположения
     */
    @GET(WeatherUrl.CURRENT)
    fun getCurrentWeatherInfo(@Query("lat") lat: Float, @Query("lon") lon: Float): Single<WeatherResponse>
}