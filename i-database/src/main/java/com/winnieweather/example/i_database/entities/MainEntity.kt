package com.winnieweather.example.i_database.entities

import androidx.room.ColumnInfo
import com.winnieweather.example.domain.weather.Main
import com.winnieweather.example.i_network.network.Transformable

data class MainEntity(
        @ColumnInfo(name = "temp") val temp: Float,
        @ColumnInfo(name = "feelsLike") val feelsLike: Float,
        @ColumnInfo(name = "tempMin") val tempMin: Float,
        @ColumnInfo(name = "tempMax") val tempMax: Float,
        @ColumnInfo(name = "pressure") val pressure: Float,
        @ColumnInfo(name = "humidity") val humidity: Int
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

fun Main.transformToEntity(): MainEntity {

    return MainEntity(
            temp = temp,
            feelsLike = feelsLike,
            tempMin = tempMin,
            tempMax = tempMax,
            pressure = pressure,
            humidity = humidity
    )
}