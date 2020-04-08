package com.winnieweather.example.i_weather.response

import com.google.gson.annotations.SerializedName
import com.winnieweather.example.domain.weather.Main
import com.winnieweather.example.i_network.network.Transformable

/**
 * Респонс модель информации о темрературе, трансформируется в [Main]
 *
 * @property temp температура в цельсий
 * @property feelsLike Как чувствуется темература
 * @property tempMin минимальная температура
 * @property tempMax максимальная температура
 * @property pressure давление
 * @property humidity влажность в процентах
 */
class MainObj(
        @SerializedName("temp") val temp: Float,
        @SerializedName("feels_like") val feelsLike: Float,
        @SerializedName("temp_min") val tempMin: Float,
        @SerializedName("temp_max") val tempMax: Float,
        @SerializedName("pressure") val pressure: Float,
        @SerializedName("humidity") val humidity: Int
) : Transformable<Main> {

    override fun transform() = Main(
            temp = temp,
            feelsLike = feelsLike,
            tempMin = tempMin,
            tempMax = tempMax,
            pressure = pressure,
            humidity = humidity
    )
}