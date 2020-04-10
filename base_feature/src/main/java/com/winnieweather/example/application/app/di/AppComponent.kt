package com.winnieweather.example.application.app.di

import dagger.Component
import ru.surfstudio.android.dagger.scope.PerApplication
import com.winnieweather.example.application.cache.di.CacheModule
import com.winnieweather.example.application.database.di.DatabaseModule
import com.winnieweather.example.application.migration.di.MigrationModule
import com.winnieweather.example.application.network.di.EtagModule
import com.winnieweather.example.application.network.di.NetworkModule
import com.winnieweather.example.application.network.di.OkHttpModule
import com.winnieweather.example.application.notification.FcmModule
import com.winnieweather.example.application.notification.MessagingService
import com.winnieweather.example.application.notification.NotificationModule
import com.winnieweather.example.application.storage.di.SharedPrefModule
import com.winnieweather.example.application.weather.di.WeatherModule

@PerApplication
@Component(modules = [
    AppModule::class,
    MigrationModule::class,
    SharedPrefModule::class,
    CacheModule::class,
    EtagModule::class,
    NetworkModule::class,
    OkHttpModule::class,
    FcmModule::class,
    NotificationModule::class,
    WeatherModule::class,
    DatabaseModule::class
])
interface AppComponent : AppProxyDependencies {
    fun inject(to: MessagingService)
}