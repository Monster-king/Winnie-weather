package com.winnieweather.example.i_database

import androidx.room.*
import com.winnieweather.example.domain.weather.WeatherInfo
import com.winnieweather.example.i_database.entities.WeatherInfoEntity
import com.winnieweather.example.i_database.entities.transformToEntity
import io.reactivex.Completable
import io.reactivex.Observable

/**
 *
 * Dao class in order to communicate with Kennekt db
 */
@Dao
abstract class WeatherInfoDao {

    /**
     * Удаляет старые данные из бд и записывает новое
     *
     * @param weatherInfo новая информация которая нужно сохранить в бд
     */
    @Transaction
    open fun updateWeatherInfo(weatherInfo: WeatherInfo) {
        clearInfo()
        insertWeatherInfo(weatherInfo.transformToEntity())
    }

    /**
     * Метод сохраняет заданную информацию в бд
     *
     * @param weatherInfo информация которая нужна сохранить в бд
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertWeatherInfo(weatherInfo: WeatherInfoEntity)

    @Query("DELETE FROM weather_info WHERE 1")
    abstract fun clearInfo()

    @Query("SELECT * FROM weather_info LIMIT 1")
    abstract fun observeWeatherInfo(): Observable<WeatherInfoEntity>
}