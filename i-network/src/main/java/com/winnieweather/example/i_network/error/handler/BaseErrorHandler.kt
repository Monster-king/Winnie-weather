package com.winnieweather.example.i_network.error.handler

import com.winnieweather.example.i_network.error.HttpProtocolException

/**
 * Базовый класс обработки ошибок сервера
 */
interface BaseErrorHandler {

    fun handle(e: HttpProtocolException)
}
