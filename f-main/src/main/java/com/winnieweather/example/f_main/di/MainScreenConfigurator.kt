package com.winnieweather.example.f_main.di

import android.content.Context
import android.content.Intent
import com.google.android.gms.location.LocationRequest
import dagger.Component
import dagger.Module
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import com.winnieweather.example.f_main.MainActivityView
import com.winnieweather.example.f_main.MainPresenter
import com.winnieweather.example.ui.activity.di.ActivityComponent
import com.winnieweather.example.ui.activity.di.ActivityScreenConfigurator
import com.winnieweather.example.ui.navigation.MainActivityRoute
import com.winnieweather.example.ui.permission.LocationPermissionRational
import com.winnieweather.example.ui.screen.ActivityScreenModule
import com.winnieweather.example.ui.screen.CustomScreenModule
import dagger.Provides
import ru.surfstudio.android.core.mvp.configurator.BindableScreenComponent
import ru.surfstudio.android.location.location_errors_resolver.resolutions.impl.concrete.no_location_permission.LocationPermissionRequest

/**
 * Конфигуратор главного экрана
 */
class MainScreenConfigurator(intent: Intent) : ActivityScreenConfigurator(intent) {

    @Suppress("DEPRECATION")
    override fun createScreenComponent(
            parentComponent: ActivityComponent,
            activityScreenModule: ActivityScreenModule,
            intent: Intent
    ): ScreenComponent<*> {
        return DaggerMainScreenConfigurator_MainScreenComponent.builder()
                .activityComponent(parentComponent)
                .activityScreenModule(activityScreenModule)
                .mainScreenModule(MainScreenModule(MainActivityRoute()))
                .build()
    }

    @PerScreen
    @Component(dependencies = [ActivityComponent::class],
            modules = [ActivityScreenModule::class, MainScreenModule::class])
    interface MainScreenComponent : BindableScreenComponent<MainActivityView>

    @Module
    internal class MainScreenModule(
            route: MainActivityRoute
    ) : CustomScreenModule<MainActivityRoute>(route) {

        @Provides
        @PerScreen
        fun provideLocationRequest(context: Context): LocationPermissionRequest {
            return LocationPermissionRational(context)
        }

        @Provides
        @PerScreen
        fun providePresenter(p: MainPresenter) = Any()
    }
}