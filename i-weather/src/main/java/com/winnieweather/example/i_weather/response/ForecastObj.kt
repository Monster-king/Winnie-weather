package com.winnieweather.example.i_weather.response

import com.google.gson.annotations.SerializedName
import com.winnieweather.example.domain.weather.Forecast
import com.winnieweather.example.i_network.network.Transformable

/**
 * Респонс модель прогноза погоды, трансформирутся в [Forecast]
 *
 * @property weather информация о погоде
 * @property main информация о температуре
 * @property visibility видимость в метрах
 * @property wind информация о ветере
 * @property clouds информация об облачности
 * @property system системная информация
 */
class ForecastObj(
        @SerializedName("weather") val weather: WeatherObj,
        @SerializedName("main") val main: MainObj,
        @SerializedName("visibility") val visibility: Long,
        @SerializedName("wind") val wind: WindObj,
        @SerializedName("clouds") val clouds: CloudsObj,
        @SerializedName("sys") val system: SystemInfoObj
) : Transformable<Forecast> {

    override fun transform() = Forecast(
            weather = weather.transform(),
            main = main.transform(),
            visibility = visibility,
            wind = wind.transform(),
            clouds = clouds.transform(),
            systemInfo = system.transform()
    )
}