package com.winnieweather.example.f_debug.injector.ui.screen.configurator.activity

import android.content.Intent
import dagger.Component
import dagger.Module
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import com.winnieweather.example.f_debug.debug.DebugActivityRoute
import com.winnieweather.example.f_debug.debug.DebugActivityView
import com.winnieweather.example.f_debug.injector.ui.DebugActivityComponent
import com.winnieweather.example.f_debug.injector.ui.configurator.DebugActivityScreenConfigurator
import com.winnieweather.example.f_debug.injector.ui.screen.DebugActivityScreenModule
import com.winnieweather.example.f_debug.injector.ui.screen.DebugCustomScreenModule

/**
 * Конфигуратор экрана показа информации для дебага
 */
class DebugScreenConfigurator(intent: Intent) : DebugActivityScreenConfigurator(intent) {

    @PerScreen
    @Component(
            dependencies = [DebugActivityComponent::class],
            modules = [DebugActivityScreenModule::class, DebugScreenModule::class]
    )
    interface DebugScreenComponent : ScreenComponent<DebugActivityView>

    @Module
    internal class DebugScreenModule(route: DebugActivityRoute)
        : DebugCustomScreenModule<DebugActivityRoute>(route)

    @Suppress("DEPRECATION")
    override fun createScreenComponent(parentComponent: DebugActivityComponent,
                                       activityScreenModule: DebugActivityScreenModule,
                                       intent: Intent): ScreenComponent<*> {
        return DaggerDebugScreenConfigurator_DebugScreenComponent.builder()
                .debugActivityComponent(parentComponent)
                .debugActivityScreenModule(activityScreenModule)
                .debugScreenModule(DebugScreenModule(DebugActivityRoute()))
                .build()
    }
}
