package com.winnieweather.example.ui.activity.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.surfstudio.android.core.ui.event.ScreenEventDelegateManager
import ru.surfstudio.android.core.ui.permission.PermissionManager
import ru.surfstudio.android.core.ui.provider.ActivityProvider
import ru.surfstudio.android.dagger.scope.PerActivity
import ru.surfstudio.android.dagger.scope.PerApplication
import ru.surfstudio.android.location.DefaultLocationInteractor
import ru.surfstudio.android.location.LocationService

@Module
class LocationModule {

    @Provides
    @PerActivity
    fun provideLocationService(context: Context): LocationService {
        return LocationService(context)
    }

    @Provides
    @PerActivity
    fun provideLocationInteractor(
            permissionManager: PermissionManager,
            screenEventDelegateManager: ScreenEventDelegateManager,
            activityProvider: ActivityProvider,
            locationService: LocationService
    ): DefaultLocationInteractor {
        return DefaultLocationInteractor(
                permissionManager,
                screenEventDelegateManager,
                activityProvider,
                locationService
        )
    }
}