package com.winnieweather.example.i_network.error

/**
 * типы специфичных ошибок сервера
 *
 * @param code код ошибки
 */
enum class ApiErrorType(private val code: Int) {
    UNKNOWN(-1);

    companion object {

        fun getByCode(code: Int?): ApiErrorType =
                values().firstOrNull { error -> error.code == code } ?: UNKNOWN
    }
}
