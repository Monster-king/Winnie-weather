package com.winnieweather.example.i_weather

import com.winnieweather.example.domain.weather.WeatherInfo
import com.winnieweather.example.i_network.network.transform
import io.reactivex.Single
import ru.surfstudio.android.dagger.scope.PerApplication
import javax.inject.Inject

/**
 * Удаленное хранилище информации погоды
 */
@PerApplication
class WeatherRepository @Inject constructor(
        private val weatherApi: WeatherApi
) {

    /**
     * Возвращает текущую информацию погоды по заданной геолокации
     *
     * @param lat широта (latitude) местоположения
     * @param lon долгота (longitude) местоположения
     */
    fun getCurrentWeatherInfo(lat: Float, lon: Float): Single<WeatherInfo> {
        return weatherApi.getCurrentWeatherInfo(lat, lon).transform()
    }
}