package com.winnieweather.example.f_splash

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.annotation.LayoutRes
import ru.surfstudio.android.core.mvp.activity.CoreActivityView
import ru.surfstudio.android.core.mvp.presenter.CorePresenter
import ru.surfstudio.android.notification.ui.notification.PushHandlingActivity
import com.winnieweather.example.f_splash.di.SplashScreenConfigurator
import javax.inject.Inject

class SplashActivityView : CoreActivityView(), PushHandlingActivity {

    @Inject
    internal lateinit var presenter: SplashPresenter

    @LayoutRes
    override fun getContentView(): Int = R.layout.activity_splash

    override fun getPresenters(): Array<CorePresenter<*>> = arrayOf(presenter)

    override fun createConfigurator() = SplashScreenConfigurator(intent)

    override fun getScreenName(): String = "SplashActivityView"

    override fun onCreate(
            savedInstanceState: Bundle?,
            persistentState: PersistableBundle?,
            viewRecreated: Boolean
    ) {
        super.onCreate(savedInstanceState, persistentState, viewRecreated)
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
    }
}