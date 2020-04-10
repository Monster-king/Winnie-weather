package com.winnieweather.example.i_database.entities

import androidx.room.ColumnInfo
import com.winnieweather.example.domain.weather.Clouds
import com.winnieweather.example.i_network.network.Transformable

data class CloudsEntity(
        @ColumnInfo(name = "all") val all: Int
) : Transformable<Clouds> {

    override fun transform() = Clouds(
            all = all
    )
}

fun Clouds.transformToEntity(): CloudsEntity {

    return CloudsEntity(
            all = all
    )
}