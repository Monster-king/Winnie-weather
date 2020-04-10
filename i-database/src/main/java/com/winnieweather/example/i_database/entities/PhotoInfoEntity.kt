package com.winnieweather.example.i_database.entities

import androidx.room.ColumnInfo
import com.winnieweather.example.domain.weather.PhotoInfo
import com.winnieweather.example.i_network.network.Transformable

data class PhotoInfoEntity(
        @ColumnInfo(name = "url") val url: String
) : Transformable<PhotoInfo> {

    override fun transform() = PhotoInfo(
            url = url
    )
}

fun PhotoInfo.transformToEntity(): PhotoInfoEntity {
    return PhotoInfoEntity(
            url = url
    )
}