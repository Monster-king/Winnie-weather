package com.winnieweather.example.f_main.detail.di

import com.example.standarddialog.StandardDialogComponent
import com.example.standarddialog.StandardDialogPresenter
import com.winnieweather.example.f_main.detail.DetailInfoWidget
import com.winnieweather.example.f_main.detail.DetailInfoWidgetPresenter
import com.winnieweather.example.ui.activity.di.ActivityComponent
import com.winnieweather.example.ui.widget.di.WidgetScreenConfigurator
import com.winnieweather.example.ui.widget.di.WidgetScreenModule
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.surfstudio.android.core.mvp.configurator.BindableScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen

class DetailInfoWidgetConfigurator : WidgetScreenConfigurator() {

    override fun createScreenComponent(
            parentComponent: ActivityComponent?,
            widgetScreenModule: WidgetScreenModule?
    ): DetailInfoWidgetComponent {
        return DaggerDetailInfoWidgetConfigurator_DetailInfoWidgetComponent.builder()
                .activityComponent(parentComponent)
                .widgetScreenModule(widgetScreenModule)
                .detailInfoWidgetModule(DetailInfoWidgetModule())
                .build()
    }

    @PerScreen
    @Component(
            dependencies = [ActivityComponent::class],
            modules = [WidgetScreenModule::class, DetailInfoWidgetModule::class]
    )
    interface DetailInfoWidgetComponent : BindableScreenComponent<DetailInfoWidget>

    @Module
    internal class DetailInfoWidgetModule {

        @Provides
        @PerScreen
        fun providePresenter(presenter: DetailInfoWidgetPresenter) = Any()
    }
}