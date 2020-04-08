package com.winnieweather.example.f_debug.system_settings

import android.content.Context
import android.content.Intent
import android.provider.Settings
import ru.surfstudio.android.core.ui.navigation.activity.route.ActivityRoute

class DeveloperToolsDebugActivityRoute : ActivityRoute() {
    override fun prepareIntent(context: Context): Intent {
        return Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
    }
}