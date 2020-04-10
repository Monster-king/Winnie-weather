package com.winnieweather.example.application.database.di

import android.content.Context
import com.winnieweather.example.i_database.WeatherDatabase
import com.winnieweather.example.i_database.WeatherInfoDao
import com.winnieweather.example.i_database.createDatabase
import dagger.Module
import dagger.Provides
import ru.surfstudio.android.dagger.scope.PerApplication

@Module
class DatabaseModule {

    @Provides
    @PerApplication
    internal fun provideDatabase(context: Context): WeatherDatabase {
        return createDatabase(context)
    }

    @Provides
    @PerApplication
    internal fun provideCasesDao(database: WeatherDatabase): WeatherInfoDao {
        return database.weatherInfo()
    }
}