package com.winnieweather.example.base.util

import java.util.*

/**
 * Утилиты для [Locale] и таймзон
 */

const val DEFAULT_LOCALE_EN_RES = "en"
val DEFAULT_LOCALE_EN = Locale(DEFAULT_LOCALE_EN_RES)

val defaultLocale: Locale
    get() = try {
        Locale.getDefault()
    } catch (e: IllegalArgumentException) {
        DEFAULT_LOCALE_EN
    }