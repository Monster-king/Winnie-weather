package com.winnieweather.example.i_database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.winnieweather.example.domain.weather.Forecast
import com.winnieweather.example.i_network.network.Transformable

data class ForecastEntity(
        @Embedded(prefix = "weather_") val weather: WeatherEntity,
        @Embedded(prefix = "main_") val main: MainEntity,
        @ColumnInfo(name = "visibility") val visibility: Long,
        @Embedded(prefix = "wind_") val wind: WindEntity,
        @Embedded(prefix = "clouds_") val clouds: CloudsEntity,
        @Embedded(prefix = "sys_") val systemInfo: SystemInfoEntity,
        @ColumnInfo(name = "name") val name: String
) : Transformable<Forecast> {

    override fun transform() = Forecast(
            weather = weather.transform(),
            main = main.transform(),
            visibility = visibility,
            wind = wind.transform(),
            clouds = clouds.transform(),
            systemInfo = systemInfo.transform(),
            name = name
    )
}

fun Forecast.transformToEntity(): ForecastEntity {
    return ForecastEntity(
            weather = weather.transformToEntity(),
            main = main.transformToEntity(),
            visibility = visibility,
            wind = wind.transformToEntity(),
            clouds = clouds.transformToEntity(),
            systemInfo = systemInfo.transformToEntity(),
            name = name
    )
}