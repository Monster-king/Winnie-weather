package com.winnieweather.example.i_database.entities

import androidx.room.ColumnInfo
import com.winnieweather.example.domain.weather.Weather
import com.winnieweather.example.i_network.network.Transformable

data class WeatherEntity(
        @ColumnInfo(name = "id") val id: Int,
        @ColumnInfo(name = "main") val main: String,
        @ColumnInfo(name = "description") val description: String,
        @ColumnInfo(name = "icon") val icon: String
) : Transformable<Weather> {

    override fun transform() = Weather(
            id = id,
            main = main,
            description = description,
            icon = icon
    )
}

fun Weather.transformToEntity(): WeatherEntity {

    return WeatherEntity(
            id = id,
            main = main,
            description = description,
            icon = icon
    )
}