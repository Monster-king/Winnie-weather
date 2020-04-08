package com.winnieweather.example.i_network.error

import com.google.gson.annotations.SerializedName

/**
 * Специфичный ответ сервера в случае 400 ошибки
 */
data class ServerErrorResponse (
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String
)