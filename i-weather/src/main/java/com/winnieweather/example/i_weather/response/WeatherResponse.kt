package com.winnieweather.example.i_weather.response

import com.google.gson.annotations.SerializedName
import com.winnieweather.example.domain.weather.WeatherInfo
import com.winnieweather.example.i_network.network.Transformable

/**
 * Респонс модель информации о погоде, трансформируется в [WeatherInfo]
 *
 * @property forecast информация о погоде
 * @property photo фотография местоположения
 */
class WeatherResponse(
        @SerializedName("weather_info") val forecast: ForecastObj,
        @SerializedName("photo") val photo: PhotoObj
) : Transformable<WeatherInfo> {

    override fun transform() = WeatherInfo(
            forecast = forecast.transform(),
            photoInfo = photo.transform()
    )
}