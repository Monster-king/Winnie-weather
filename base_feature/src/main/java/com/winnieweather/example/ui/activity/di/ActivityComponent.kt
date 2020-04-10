package com.winnieweather.example.ui.activity.di

import dagger.Component
import ru.surfstudio.android.dagger.scope.PerActivity
import com.winnieweather.example.application.app.di.AppComponent
import com.winnieweather.example.application.app.di.AppProxyDependencies

/**
 * Компонент для @[PerActivity] скоупа
 */
@PerActivity
@Component(
        dependencies = [AppComponent::class],
        modules = [
            ActivityModule::class,
            LocationModule::class
        ]
)
interface ActivityComponent : AppProxyDependencies, ActivityProxyDependencies