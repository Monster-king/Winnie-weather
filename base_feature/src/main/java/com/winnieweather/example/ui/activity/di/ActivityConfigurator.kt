package com.winnieweather.example.ui.activity.di

import android.content.Context
import ru.surfstudio.android.core.ui.configurator.BaseActivityConfigurator
import com.winnieweather.example.application.app.di.AppComponent
import com.winnieweather.example.application.app.di.AppInjector

class ActivityConfigurator(
        val context: Context
) : BaseActivityConfigurator<ActivityComponent, AppComponent>() {

    override fun createActivityComponent(parentComponent: AppComponent?): ActivityComponent =
            DaggerActivityComponent.builder()
                    .appComponent(parentComponent)
                    .build()

    override fun getParentComponent(): AppComponent = AppInjector.appComponent
}