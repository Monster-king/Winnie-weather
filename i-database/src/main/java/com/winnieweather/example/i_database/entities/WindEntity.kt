package com.winnieweather.example.i_database.entities

import androidx.room.ColumnInfo
import com.winnieweather.example.domain.weather.Wind
import com.winnieweather.example.i_network.network.Transformable

data class WindEntity(
        @ColumnInfo(name = "speed") val speed: Float,
        @ColumnInfo(name = "deg") val deg: Int
) : Transformable<Wind> {

    override fun transform() = Wind(
            speed = speed,
            deg = deg
    )
}

fun Wind.transformToEntity(): WindEntity {
    return WindEntity(
            speed = speed,
            deg = deg
    )
}