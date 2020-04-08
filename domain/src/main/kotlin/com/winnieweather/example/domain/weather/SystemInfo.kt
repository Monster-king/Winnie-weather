package com.winnieweather.example.domain.weather

/**
 * Системная информация
 *
 * @property country код страны
 * @property sunrise время восхода в UTC
 * @property sunset время заката в UTC
 */
data class SystemInfo(
        val country: String,
        val sunrise: Long,
        val sunset: Long
)