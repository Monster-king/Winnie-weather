package com.winnieweather.example.base.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Утилиты для форматирования даты
 */

///region patterns
const val WEEK_NAME_PATTERN = "EEEE"
const val TWELVE_HOUR_PATTERN = "h:mm a"
///endregion

/**
 * Отформатировать дату по паттерну
 *
 * @param datePattern паттерн по которому необходимо форматировать
 * @return отформатированния строка
 */
fun Date.format(datePattern: String): String =
        SimpleDateFormat(datePattern, defaultLocale).format(this)

/**
 * Возвращает день недели в строковом формате
 */
fun getCurrentWeekDay(): String {
    val c = Calendar.getInstance()
    return c.time.format(WEEK_NAME_PATTERN)
}

/**
 * Возвращает текущий час
 */
fun getCurrentHour(): String {
    val calendar = Calendar.getInstance()
    val hourOfDay = calendar[Calendar.HOUR_OF_DAY]
    return String.format("%02d:00", hourOfDay)
}

/**
 * Возвращает время на текущем
 */
fun Long.toLocalDate(): Date {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this * 1000
    return calendar.time
}