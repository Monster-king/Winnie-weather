package com.winnieweather.example.f_main.detail

import com.winnieweather.example.i_weather.WeatherInteractor
import ru.surfstudio.android.core.mvp.binding.rx.ui.BaseRxPresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.dagger.scope.PerScreen
import javax.inject.Inject

@PerScreen
class DetailInfoWidgetPresenter @Inject constructor(
        basePresenterDependency: BasePresenterDependency,
        private val bm: DetailInfoWidgetBindModel,
        private val weatherInteractor: WeatherInteractor
) : BaseRxPresenter(basePresenterDependency) {

    override fun onFirstLoad() {
        subscribeToWeatherInfo()
    }

    private fun subscribeToWeatherInfo() {
        subscribe(
                weatherInteractor.weatherInfoObservable
        ) {
            bm.weatherInfoState.accept(it)
        }
    }
}