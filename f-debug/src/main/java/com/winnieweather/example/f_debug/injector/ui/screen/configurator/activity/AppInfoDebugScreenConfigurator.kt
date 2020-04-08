package com.winnieweather.example.f_debug.injector.ui.screen.configurator.activity

import android.content.Intent
import dagger.Component
import dagger.Module
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import com.winnieweather.example.f_debug.info.AppInfoDebugActivityRoute
import com.winnieweather.example.f_debug.info.AppInfoDebugActivityView
import com.winnieweather.example.f_debug.injector.ui.DebugActivityComponent
import com.winnieweather.example.f_debug.injector.ui.configurator.DebugActivityScreenConfigurator
import com.winnieweather.example.f_debug.injector.ui.screen.DebugActivityScreenModule
import com.winnieweather.example.f_debug.injector.ui.screen.DebugCustomScreenModule

/**
 * Конфигуратор экрана показа общей информации
 */
class AppInfoDebugScreenConfigurator(intent: Intent) : DebugActivityScreenConfigurator(intent) {

    @PerScreen
    @Component(
            dependencies = [DebugActivityComponent::class],
            modules = [DebugActivityScreenModule::class, AppInfoDebugScreenModule::class]
    )
    interface AppInfoDebugScreenComponent : ScreenComponent<AppInfoDebugActivityView>

    @Module
    internal class AppInfoDebugScreenModule(route: AppInfoDebugActivityRoute)
        : DebugCustomScreenModule<AppInfoDebugActivityRoute>(route)

    @Suppress("DEPRECATION")
    override fun createScreenComponent(
            parentComponent: DebugActivityComponent,
            activityScreenModule: DebugActivityScreenModule,
            intent: Intent
    ): ScreenComponent<*> {
        return DaggerAppInfoDebugScreenConfigurator_AppInfoDebugScreenComponent.builder()
                .debugActivityComponent(parentComponent)
                .debugActivityScreenModule(activityScreenModule)
                .appInfoDebugScreenModule(AppInfoDebugScreenModule(AppInfoDebugActivityRoute()))
                .build()
    }
}
