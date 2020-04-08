package com.winnieweather.example.f_splash.di

import android.content.Intent
import dagger.Component
import dagger.Module
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import com.winnieweather.example.f_splash.SplashActivityView
import com.winnieweather.example.f_splash.SplashRoute
import com.winnieweather.example.ui.activity.di.ActivityComponent
import com.winnieweather.example.ui.activity.di.ActivityScreenConfigurator
import com.winnieweather.example.ui.screen.ActivityScreenModule
import com.winnieweather.example.ui.screen.CustomScreenModule

/**
 * Конфигуратор стартового сплеш-экрана [SplashActivityView]
 */
class SplashScreenConfigurator(intent: Intent) : ActivityScreenConfigurator(intent) {

    @PerScreen
    @Component(dependencies = [ActivityComponent::class], modules = [ActivityScreenModule::class, SplashScreenModule::class])
    interface SplashScreenComponent : ScreenComponent<SplashActivityView>

    @Module
    class SplashScreenModule(route: SplashRoute) :
            CustomScreenModule<SplashRoute>(route)

    override fun createScreenComponent(activityComponent: ActivityComponent,
                                       activityScreenModule: ActivityScreenModule,
                                       intent: Intent): ScreenComponent<*> {
        @Suppress("DEPRECATION")
        return DaggerSplashScreenConfigurator_SplashScreenComponent.builder()
                .activityComponent(activityComponent)
                .activityScreenModule(activityScreenModule)
                .splashScreenModule(SplashScreenModule(SplashRoute()))
                .build()
    }
}