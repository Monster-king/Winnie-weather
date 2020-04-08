package com.winnieweather.example.i_weather.response

import com.google.gson.annotations.SerializedName
import com.winnieweather.example.domain.weather.SystemInfo
import com.winnieweather.example.i_network.network.Transformable

/**
 * Респонс модель системной информации, трансформируется в [SystemInfo]
 *
 * @property country код страны
 * @property sunrise время восхода в UTC
 * @property sunset время заката в UTC
 */
class SystemInfoObj(
        @SerializedName("country") val country: String,
        @SerializedName("sunrise") val sunrise: Long,
        @SerializedName("sunset") val sunset: Long
) : Transformable<SystemInfo> {

    override fun transform() = SystemInfo(
            country = country,
            sunrise = sunrise,
            sunset = sunset
    )
}