package com.winnieweather.example.i_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.winnieweather.example.i_database.entities.WeatherInfoEntity

private const val DATABASE_NAME = "Winnie-weather"

@Database(
        entities = [
            WeatherInfoEntity::class
        ],
        version = 1
)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun weatherInfo(): WeatherInfoDao
}

fun createDatabase(context: Context): WeatherDatabase {
    return Room.databaseBuilder(
            context,
            WeatherDatabase::class.java,
            DATABASE_NAME
    ).build()
}