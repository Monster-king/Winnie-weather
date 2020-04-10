package com.winnieweather.example.f_main

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import com.winnieweather.example.base.util.getCurrentHour
import com.winnieweather.example.base.util.getCurrentWeekDay
import com.winnieweather.example.domain.weather.WeatherInfo
import com.winnieweather.example.f_main.di.MainScreenConfigurator
import com.winnieweather.example.ui.utils.description
import com.winnieweather.example.ui.utils.emojiIcon
import com.winnieweather.example.ui.utils.locationName
import kotlinx.android.synthetic.main.activity_main.*
import ru.surfstudio.android.core.mvp.binding.rx.ui.BaseRxActivityView
import ru.surfstudio.android.imageloader.ImageLoader
import ru.surfstudio.android.imageloader.transformations.RoundedCornersTransformation
import javax.inject.Inject

/**
 * Вью главного экрана
 */
class MainActivityView : BaseRxActivityView() {

    @Inject
    lateinit var bm: MainBindModel

    override fun createConfigurator() = MainScreenConfigurator(intent)

    @LayoutRes
    override fun getContentView(): Int = R.layout.activity_main

    override fun getScreenName(): String = "MainActivityView"

    override fun onCreate(
            savedInstanceState: Bundle?,
            persistentState: PersistableBundle?,
            viewRecreated: Boolean
    ) {
        bind()
    }

    private fun bind() {
        bm.weatherState bindTo ::renderWeatherData
    }

    private fun renderWeatherData(weatherInfo: WeatherInfo) {
        ImageLoader.with(this)
                .url(weatherInfo.photoInfo.url)
                .centerCrop(true)
                .roundedCorners(true, resources.getDimensionPixelSize(R.dimen.city_image_radius), 0, RoundedCornersTransformation.CornerType.ALL)
                .into(city_image_iv)

        day_tv.text = "${getCurrentWeekDay()},"
        time_tv.text = getCurrentHour()
        weather_icon_tv.text = weatherInfo.forecast.weather.emojiIcon
        temp_tv.text = weatherInfo.forecast.main.temp.toString()
        cloud_tv.text = weatherInfo.forecast.clouds.description(this)
        description_tv.text = weatherInfo.forecast.weather.description.capitalize()
        city_name_tv.text = weatherInfo.forecast.locationName
    }
}
