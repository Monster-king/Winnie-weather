package com.winnieweather.example.f_main.di

import android.content.Intent
import dagger.Component
import dagger.Module
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import com.winnieweather.example.f_main.MainActivityView
import com.winnieweather.example.ui.activity.di.ActivityComponent
import com.winnieweather.example.ui.activity.di.ActivityScreenConfigurator
import com.winnieweather.example.ui.navigation.MainActivityRoute
import com.winnieweather.example.ui.screen.ActivityScreenModule
import com.winnieweather.example.ui.screen.CustomScreenModule

/**
 * Конфигуратор главного экрана
 */
class MainScreenConfigurator(intent: Intent) : ActivityScreenConfigurator(intent) {

    @PerScreen
    @Component(dependencies = [ActivityComponent::class],
            modules = [ActivityScreenModule::class, MainScreenModule::class])
    interface MainScreenComponent
        : ScreenComponent<MainActivityView>

    @Module
    internal class MainScreenModule(route: MainActivityRoute) : CustomScreenModule<MainActivityRoute>(route)

    @Suppress("DEPRECATION")
    override fun createScreenComponent(parentComponent: ActivityComponent,
                                       activityScreenModule: ActivityScreenModule,
                                       intent: Intent): ScreenComponent<*> {
        return DaggerMainScreenConfigurator_MainScreenComponent.builder()
                .activityComponent(parentComponent)
                .activityScreenModule(activityScreenModule)
                .mainScreenModule(MainScreenModule(MainActivityRoute()))
                .build()
    }
}