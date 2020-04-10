package com.winnieweather.example.f_main

import com.winnieweather.example.domain.weather.WeatherInfo
import ru.surfstudio.android.core.mvp.binding.rx.relation.mvp.Action
import ru.surfstudio.android.core.mvp.binding.rx.relation.mvp.State
import ru.surfstudio.android.core.mvp.binding.rx.ui.BindModel
import ru.surfstudio.android.core.mvp.loadstate.LoadStateInterface
import ru.surfstudio.android.dagger.scope.PerScreen
import javax.inject.Inject

/**
 * Модель главного экрана
 */
@PerScreen
class MainBindModel @Inject constructor() : BindModel {

    val loadState = State<LoadStateInterface>()
    val weatherState = State<WeatherInfo>()

    val getNewLocationAction = Action<Unit>()
}
