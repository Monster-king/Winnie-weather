package com.winnieweather.example.ui.navigation

import ru.surfstudio.android.core.ui.navigation.feature.route.feature.ActivityCrossFeatureRoute

/**
 * Роут главного экрана
 */
class MainActivityRoute : ActivityCrossFeatureRoute() {

    override fun targetClassPath(): String {
        return "com.winnieweather.example.f_main.MainActivityView"
    }
}