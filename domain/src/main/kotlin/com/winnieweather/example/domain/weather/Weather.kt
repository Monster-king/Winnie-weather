package com.winnieweather.example.domain.weather

/**
 * Информация о погоде
 *
 * @property id идентификатор погоды
 * @property main группа параметров погоды (Rain, Snow, Extreme итд.)
 * @property description погодные условия
 * @property icon иконка погоды
 */
data class Weather(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
)