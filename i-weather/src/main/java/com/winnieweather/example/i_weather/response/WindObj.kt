package com.winnieweather.example.i_weather.response

import com.google.gson.annotations.SerializedName
import com.winnieweather.example.domain.weather.Wind
import com.winnieweather.example.i_network.network.Transformable

/**
 * Респонс модель информации о ветере, трансформируется в [Wind]
 *
 * @property speed скорость ветра в м/с
 * @property deg направление ветра, град (метеорологическое)
 */
class WindObj(
        @SerializedName("speed") val speed: Float,
        @SerializedName("deg") val deg: Int
) : Transformable<Wind> {

    override fun transform() = Wind(
            speed = speed,
            deg = deg
    )
}