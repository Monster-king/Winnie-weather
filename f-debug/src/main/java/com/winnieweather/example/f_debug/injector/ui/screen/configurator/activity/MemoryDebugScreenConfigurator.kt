package com.winnieweather.example.f_debug.injector.ui.screen.configurator.activity

import android.content.Intent
import dagger.Component
import dagger.Module
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import com.winnieweather.example.f_debug.injector.ui.DebugActivityComponent
import com.winnieweather.example.f_debug.injector.ui.configurator.DebugActivityScreenConfigurator
import com.winnieweather.example.f_debug.injector.ui.screen.DebugActivityScreenModule
import com.winnieweather.example.f_debug.injector.ui.screen.DebugCustomScreenModule
import com.winnieweather.example.f_debug.memory.MemoryDebugActivityRoute
import com.winnieweather.example.f_debug.memory.MemoryDebugActivityView

/**
 * Конфигуратор экрана Memory
 */
class MemoryDebugScreenConfigurator(intent: Intent) : DebugActivityScreenConfigurator(intent) {

    @PerScreen
    @Component(
            dependencies = [DebugActivityComponent::class],
            modules = [DebugActivityScreenModule::class, MemoryDebugScreenModule::class]
    )
    interface MemoryDebugScreenComponent : ScreenComponent<MemoryDebugActivityView>

    @Module
    internal class MemoryDebugScreenModule(route: MemoryDebugActivityRoute)
        : DebugCustomScreenModule<MemoryDebugActivityRoute>(route)

    @Suppress("DEPRECATION")
    override fun createScreenComponent(parentComponent: DebugActivityComponent,
                                       activityScreenModule: DebugActivityScreenModule,
                                       intent: Intent): ScreenComponent<*> {
        return DaggerMemoryDebugScreenConfigurator_MemoryDebugScreenComponent.builder()
                .debugActivityComponent(parentComponent)
                .debugActivityScreenModule(activityScreenModule)
                .memoryDebugScreenModule(MemoryDebugScreenModule(MemoryDebugActivityRoute()))
                .build()
    }
}