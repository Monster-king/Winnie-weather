package com.winnieweather.example.i_weather.response

import com.google.gson.annotations.SerializedName
import com.winnieweather.example.domain.weather.PhotoInfo
import com.winnieweather.example.i_network.network.Transformable

/**
 * Респонс модель информации о фотографии
 *
 * @property url адрес фотографии
 */
class PhotoObj(
        @SerializedName("url") val url: String
) : Transformable<PhotoInfo> {

    override fun transform() = PhotoInfo(
            url = url
    )
}