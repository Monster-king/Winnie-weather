package com.winnieweather.example.i_network.error.exception

/**
 * Базовый класс ошибки
 */
abstract class BaseMessagedException protected constructor(val developerMessage: String) : RuntimeException()
