package com.winnieweather.example.domain.weather

/**
 * Информация о ветере
 *
 * @property speed скорость ветра в м/с
 * @property deg направление ветра, град (метеорологическое)
 */
data class Wind(
        val speed: Float,
        val deg: Int
)