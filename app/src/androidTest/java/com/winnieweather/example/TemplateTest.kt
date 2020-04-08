package com.winnieweather.example

import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.winnieweather.example.common.ElapsedTimeIdlingResource
import com.winnieweather.example.common.utils.ActivityUtils.checkIfActivityIsVisible
import com.winnieweather.example.common.utils.ActivityUtils.launchActivity
import com.winnieweather.example.common.utils.IdlingUtils.registerIdlingResource
import com.winnieweather.example.common.utils.IdlingUtils.unregisterIdlingResource
import com.winnieweather.example.f_main.MainActivityView
import com.winnieweather.example.f_splash.SplashActivityView
import com.winnieweather.example.f_splash.TRANSITION_DELAY_MS
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class TemplateTest {

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun testApplicationLaunch() {
        launchActivity(SplashActivityView::class.java)
        checkIfActivityIsVisible(SplashActivityView::class.java)

        // Ожидаем, пока показывается splash-экран
        val idlingResource = ElapsedTimeIdlingResource(TRANSITION_DELAY_MS)
        registerIdlingResource(idlingResource)

        checkIfActivityIsVisible(MainActivityView::class.java)
        unregisterIdlingResource(idlingResource)
    }

    @Test
    fun testMainActivity() {
        launchActivity(MainActivityView::class.java)
    }
}