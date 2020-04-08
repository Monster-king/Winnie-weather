package com.winnieweather.example.domain.weather

/**
 * Информация о темрературе
 *
 * @property temp температура в цельсий
 * @property feelsLike Как чувствуется темература
 * @property tempMin минимальная температура
 * @property tempMax максимальная температура
 * @property pressure давление
 * @property humidity влажность в процентах
 */
data class Main(
        val temp: Float,
        val feelsLike: Float,
        val tempMin: Float,
        val tempMax: Float,
        val pressure: Float,
        val humidity: Int
)