package com.winnieweather.example.ui.permission

import android.content.Context
import com.winnieweather.example.R
import ru.surfstudio.android.location.location_errors_resolver.resolutions.impl.concrete.no_location_permission.LocationPermissionRequest

class LocationPermissionRational(
        context: Context
) : LocationPermissionRequest() {

    init {
        showPermissionsRational = true
        permissionsRationalStr = context.getString(R.string.permission_rational)

        showSettingsRational = true
        settingsRationalStr = context.getString(R.string.settings_rational)
    }
}