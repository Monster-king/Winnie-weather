package com.winnieweather.example.i_weather

import android.os.Build
import com.winnieweather.example.i_weather.di.DaggerTestWeatherApiComponent
import com.winnieweather.example.i_weather.di.TestWeatherApiComponent
import com.winnieweather.example.small_test_utils.ApiTestRunner
import com.winnieweather.example.small_test_utils.BaseNetworkDaggerTest
import com.winnieweather.example.small_test_utils.app.TestApp
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import javax.inject.Inject

@RunWith(ApiTestRunner::class)
@Config(application = TestApp::class, sdk = [Build.VERSION_CODES.O_MR1])
class WeatherApiTest : BaseNetworkDaggerTest<TestWeatherApiComponent>() {

    @Inject
    lateinit var weatherRepository: WeatherRepository

    override val component: TestWeatherApiComponent = DaggerTestWeatherApiComponent.builder()
            .testNetworkAppComponent(networkAppComponent)
            .build()

    override fun inject() {
        component.inject(this)
    }

    @Test
    fun testCurrentWeatherInfo() {
        val lat = 41.2995f
        val lon = 69.2401f
        test(weatherRepository.getCurrentWeatherInfo(lat, lon))
    }
}