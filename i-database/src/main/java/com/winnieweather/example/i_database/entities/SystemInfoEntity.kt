package com.winnieweather.example.i_database.entities

import androidx.room.ColumnInfo
import com.winnieweather.example.domain.weather.SystemInfo
import com.winnieweather.example.i_network.network.Transformable

data class SystemInfoEntity(
        @ColumnInfo(name = "country") val country: String,
        @ColumnInfo(name = "sunrise") val sunrise: Long,
        @ColumnInfo(name = "sunset") val sunset: Long
) : Transformable<SystemInfo> {

    override fun transform() = SystemInfo(
            country = country,
            sunrise = sunrise,
            sunset = sunset
    )
}

fun SystemInfo.transformToEntity(): SystemInfoEntity {

    return SystemInfoEntity(
            country = country,
            sunrise = sunrise,
            sunset = sunset
    )
}