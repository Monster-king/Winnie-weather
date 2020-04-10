package com.winnieweather.example.application.app.di

import android.content.Context
import android.content.SharedPreferences
import ru.surfstudio.android.activity.holder.ActiveActivityHolder
import ru.surfstudio.android.connection.ConnectionProvider
import ru.surfstudio.android.core.ui.navigation.activity.navigator.GlobalNavigator
import ru.surfstudio.android.dagger.scope.PerApplication
import ru.surfstudio.android.notification.PushHandler
import ru.surfstudio.android.rx.extension.scheduler.SchedulersProvider
import ru.surfstudio.android.shared.pref.NO_BACKUP_SHARED_PREF
import com.winnieweather.example.base.util.StringsProvider
import com.winnieweather.example.i_database.WeatherDatabase
import com.winnieweather.example.i_initialization.InitializeAppInteractor
import com.winnieweather.example.i_push_notification.storage.FcmStorage
import com.winnieweather.example.i_weather.WeatherInteractor
import ru.surfstudio.android.location.DefaultLocationInteractor
import javax.inject.Named

/**
 * Интерфейс, объединяющий в себе все зависимости в скоупе [PerApplication]
 * Следует использовать в компоненте Application и других компонентах более высоких уровней,
 * зависящих от него.
 */
interface AppProxyDependencies {
    fun initializeAppInteractor(): InitializeAppInteractor
    fun context(): Context
    fun activeActivityHolder(): ActiveActivityHolder
    fun connectionProvider(): ConnectionProvider
    fun schedulerProvider(): SchedulersProvider
    fun stringsProvider(): StringsProvider
    fun globalNavigator(): GlobalNavigator

    fun fcmStorage(): FcmStorage
    fun pushHandler(): PushHandler

    @Named(NO_BACKUP_SHARED_PREF)
    fun sharedPreferences(): SharedPreferences

    fun weatherInteractor(): WeatherInteractor

    fun database(): WeatherDatabase
}