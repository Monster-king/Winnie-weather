package com.winnieweather.example.i_database.entities

import androidx.room.*
import com.winnieweather.example.domain.weather.WeatherInfo
import com.winnieweather.example.i_network.network.Transformable

@Entity(tableName = "weather_info")
data class WeatherInfoEntity(
        @PrimaryKey @ColumnInfo(name = "id_") val id: Long,
        @Embedded(prefix = "forecast_") val forecast: ForecastEntity,
        @Embedded(prefix = "photo_") val photoInfo: PhotoInfoEntity

) : Transformable<WeatherInfo> {

    override fun transform() = WeatherInfo(
            forecast = forecast.transform(),
            photoInfo = photoInfo.transform()
    )
}

fun WeatherInfo.transformToEntity(): WeatherInfoEntity {

    return WeatherInfoEntity(
            id = 1,
            forecast = forecast.transformToEntity(),
            photoInfo = photoInfo.transformToEntity()
    )
}