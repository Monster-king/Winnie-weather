package com.winnieweather.example.application.network.di

import android.content.Context
import com.winnieweather.example.i_network.network.etag.EtagInterceptor
import com.winnieweather.example.i_network.network.etag.storage.EtagCache
import com.winnieweather.example.i_network.network.etag.storage.EtagStorage
import dagger.Module
import dagger.Provides
import ru.surfstudio.android.dagger.scope.PerApplication
import ru.surfstudio.android.filestorage.utils.AppDirectoriesProvider

@Module
class EtagModule {

    @Provides
    @PerApplication
    internal fun provideEtagCache(context: Context): EtagCache {
        return EtagCache(AppDirectoriesProvider.provideNoBackupStorageDir(context))
    }

    @Provides
    @PerApplication
    internal fun provideEtagStorage(etagCache: EtagCache): EtagStorage {
        return EtagStorage(etagCache)
    }

    @Provides
    @PerApplication
    internal fun provideEtagInterceptor(etagStorage: EtagStorage): EtagInterceptor {
        return EtagInterceptor(etagStorage)
    }
}