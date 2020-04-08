package com.winnieweather.example.ui.activity.di

import android.app.Activity
import android.content.Intent
import ru.surfstudio.android.core.mvp.configurator.BaseActivityViewConfigurator
import com.winnieweather.example.application.app.di.AppComponent
import com.winnieweather.example.application.app.di.AppInjector
import com.winnieweather.example.ui.screen.ActivityScreenModule

/**
 * Базовый конфигуратор для экрана, основанного на [Activity]
 */
abstract class ActivityScreenConfigurator(
        intent: Intent
) : BaseActivityViewConfigurator<AppComponent, ActivityComponent, ActivityScreenModule>(intent) {

    override fun createActivityComponent(parentComponent: AppComponent): ActivityComponent {
        return DaggerActivityComponent.builder()
                .appComponent(parentComponent)
                .activityModule(ActivityModule(persistentScope))
                .build()
    }

    override fun getParentComponent(): AppComponent {
        return AppInjector.appComponent
    }

    override fun getActivityScreenModule(): ActivityScreenModule {
        return ActivityScreenModule(persistentScope)
    }
}