package com.winnieweather.example.domain.weather

/**
 * Погодная информация
 *
 * @property forecast информация о погоде
 * @property photoInfo фотография местоположения
 */
data class WeatherInfo(
        val forecast: Forecast,
        val photoInfo: PhotoInfo
)