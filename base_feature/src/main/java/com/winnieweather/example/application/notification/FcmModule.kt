package com.winnieweather.example.application.notification

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import ru.surfstudio.android.dagger.scope.PerApplication
import com.winnieweather.example.i_push_notification.storage.FcmStorage
import ru.surfstudio.android.shared.pref.NO_BACKUP_SHARED_PREF
import javax.inject.Named

@Module
class FcmModule {

    @Provides
    @PerApplication
    fun provideFcmStorage(
            @Named(NO_BACKUP_SHARED_PREF) noBackupSharedPref: SharedPreferences
    ): FcmStorage {
        return FcmStorage(noBackupSharedPref)
    }
}