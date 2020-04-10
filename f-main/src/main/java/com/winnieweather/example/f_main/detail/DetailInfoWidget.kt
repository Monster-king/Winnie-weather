package com.winnieweather.example.f_main.detail

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.winnieweather.example.domain.weather.WeatherInfo
import com.winnieweather.example.f_main.R
import com.winnieweather.example.f_main.detail.controllers.HumidityItemController
import com.winnieweather.example.f_main.detail.controllers.SunsetTimeItemController
import com.winnieweather.example.f_main.detail.controllers.VisibilityItemController
import com.winnieweather.example.f_main.detail.controllers.WindStatusItemController
import com.winnieweather.example.f_main.detail.di.DetailInfoWidgetConfigurator
import kotlinx.android.synthetic.main.view_detail_info.view.*
import ru.surfstudio.android.core.mvp.binding.rx.ui.CoreRxLinearLayoutView
import ru.surfstudio.android.core.mvp.presenter.CorePresenter
import ru.surfstudio.android.core.mvp.view.CoreView
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList
import javax.inject.Inject

class DetailInfoWidget @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
) : CoreRxLinearLayoutView(context, attrs) {

    private val adapter = EasyAdapter()
    private val humidityController = HumidityItemController()
    private val sunsetTimeController = SunsetTimeItemController()
    private val visibilityController = VisibilityItemController()
    private val windStatusController = WindStatusItemController()

    @Inject
    lateinit var bm: DetailInfoWidgetBindModel

    init {
        orientation = LinearLayout.VERTICAL
        inflate(context, R.layout.view_detail_info, this)
        initRv()
    }

    override fun getName() = "DetailInfoWidget"

    override fun getPresenters() = emptyArray<CorePresenter<CoreView>>()

    override fun createConfigurator() = DetailInfoWidgetConfigurator()

    override fun onBind() {
        bm.weatherInfoState bindTo ::renderWeatherInfo
    }

    private fun initRv() {
        other_info_rv.layoutManager = GridLayoutManager(context, 2)
        other_info_rv.adapter = adapter
    }

    private fun renderWeatherInfo(weatherInfo: WeatherInfo) {
        adapter.setItems(
                ItemList.create()
                        .add(weatherInfo.forecast.wind, windStatusController)
                        .add(weatherInfo.forecast.systemInfo, sunsetTimeController)
                        .add(weatherInfo.forecast.main.humidity, humidityController)
                        .add(weatherInfo.forecast.visibility, visibilityController)
        )
    }
}