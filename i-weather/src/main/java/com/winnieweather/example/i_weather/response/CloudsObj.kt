package com.winnieweather.example.i_weather.response

import com.google.gson.annotations.SerializedName
import com.winnieweather.example.domain.weather.Clouds
import com.winnieweather.example.i_network.network.Transformable

/**
 * Респонс модель информации об облачности, трансформируется в [Clouds]
 *
 * @property all облачность в процентах
 */
class CloudsObj(
        @SerializedName("all") val all: Int
) : Transformable<Clouds> {

    override fun transform() = Clouds(
            all = all
    )
}