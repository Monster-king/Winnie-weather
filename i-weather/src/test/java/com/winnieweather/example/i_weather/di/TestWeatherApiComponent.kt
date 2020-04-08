package com.winnieweather.example.i_weather.di

import com.winnieweather.example.i_weather.WeatherApiTest
import com.winnieweather.example.small_test_utils.di.components.TestNetworkAppComponent
import com.winnieweather.example.small_test_utils.di.scope.PerTest
import dagger.Component

@PerTest
@Component(
        dependencies = [
            TestNetworkAppComponent::class
        ],
        modules = [
            WeatherApiTestModule::class
        ]
)
interface TestWeatherApiComponent {

    fun inject(test: WeatherApiTest)
}