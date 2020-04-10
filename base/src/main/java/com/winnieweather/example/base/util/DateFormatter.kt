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

fun getCurrentWeekDay(): String {
    val c = Calendar.getInstance()
    return c.time.format(WEEK_NAME_PATTERN)
}

fun getCurrentHour(): String {
    val calendar = Calendar.getInstance()
    val hourOfDay = calendar[Calendar.HOUR_OF_DAY]
    return String.format("%02d:00", hourOfDay)
}

/**
 * Отформатировать строку по паттерну
 *
 * @param datePattern паттерн по которому необходимо форматировать
 * @return отформатированния дата
 */
fun String.parseDate(datePattern: String): Date {
    return SimpleDateFormat(datePattern, defaultLocale).parse(this)
}

/**
 * Возвращает время на текущем
 */
fun Long.toLocalDate(): Date {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    return calendar.time
}

fun Date.isToday(): Boolean {
    return isSameDay(Calendar.getInstance().time)
}

fun Date.isSameDay(cmp: Date): Boolean {
    val cal1 = Calendar.getInstance()
    cal1.time = this
    val cal2 = Calendar.getInstance()
    cal2.time = cmp
    return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
            cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)
}

fun Date.isCurrentYear(): Boolean {
    val cal = Calendar.getInstance()
    cal.time = this
    return Calendar.getInstance().get(Calendar.YEAR) == cal.get(Calendar.YEAR)
}

fun String.formatDateString(from: String, to: String): String {
    return this.parseDate(from).format(to)
}