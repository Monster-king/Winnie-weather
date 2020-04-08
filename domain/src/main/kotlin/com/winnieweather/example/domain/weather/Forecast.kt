package com.winnieweather.example.domain.weather

/**
 * Прогноз погоды
 *
 * @property weather информация о погоде
 * @property main информация о температуре
 * @property visibility видимость в метрах
 * @property wind информация о ветере
 * @property clouds информация об облачности
 * @property systemInfo системная информация
 */
data class Forecast(
        val weather: Weather,
        val main: Main,
        val visibility: Long,
        val wind: Wind,
        val clouds: Clouds,
        val systemInfo: SystemInfo
)