package com.winnieweather.example.i_weather.response

import com.google.gson.annotations.SerializedName
import com.winnieweather.example.domain.weather.Weather
import com.winnieweather.example.i_network.network.Transformable

/**
 * Респонс модель информации о погоде транформируется в [Weather]
 *
 * @property id идентификатор погоды
 * @property main группа параметров погоды (Rain, Snow, Extreme итд.)
 * @property description погодные условия
 * @property icon иконка погоды
 */
class WeatherObj(
        @SerializedName("id") val id: Int,
        @SerializedName("main") val main: String,
        @SerializedName("description") val description: String,
        @SerializedName("icon") val icon: String
) : Transformable<Weather> {

    override fun transform() = Weather(
            id = id,
            main = main,
            description = description,
            icon = icon
    )
}