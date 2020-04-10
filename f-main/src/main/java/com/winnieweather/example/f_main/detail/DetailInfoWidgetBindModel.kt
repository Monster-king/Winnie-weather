package com.winnieweather.example.f_main.detail

import com.winnieweather.example.domain.weather.WeatherInfo
import ru.surfstudio.android.core.mvp.binding.rx.relation.mvp.State
import ru.surfstudio.android.core.mvp.binding.rx.ui.BindModel
import ru.surfstudio.android.dagger.scope.PerScreen
import javax.inject.Inject

@PerScreen
class DetailInfoWidgetBindModel @Inject constructor() : BindModel {

    val weatherInfoState = State<WeatherInfo>()
}