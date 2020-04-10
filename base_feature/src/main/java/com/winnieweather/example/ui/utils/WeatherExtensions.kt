package com.winnieweather.example.ui.utils

import android.content.Context
import com.winnieweather.example.R
import com.winnieweather.example.domain.weather.Clouds
import com.winnieweather.example.domain.weather.Forecast
import com.winnieweather.example.domain.weather.Weather

/**
 * Возвращает описание погоды по состоянии облаков
 */
fun Clouds.description(context: Context): String {
    return context.getString(when {
        all <= 20 -> R.string.clouds_lover_20
        all <= 50 -> R.string.clouds_lover_50
        else -> R.string.clouds_very_much
    })
}

/**
 * Возвращает комбинацию названия города и кода страны
 */
val Forecast.locationName: String
    get() = "$name, ${systemInfo.country}"

val Weather.emojiIcon: String
    get() = when {
        id < 300 -> "\uD83C\uDF29"
        id < 400 -> "\uD83C\uDF27"
        id < 600 -> "\u2614️"
        id < 700 -> "\u2603"
        id < 800 -> "\uD83C\uDF01"
        id == 800 -> "\u2600"
        id <= 804 -> "\u2601️"
        else -> "\uD83E\uDD37‍"
    }