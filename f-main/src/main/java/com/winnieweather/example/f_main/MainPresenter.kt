package com.winnieweather.example.f_main

import com.winnieweather.example.i_weather.WeatherInteractor
import com.winnieweather.example.ui.placeholder.loadstate.state.ErrorLoadState
import io.reactivex.disposables.Disposables
import ru.surfstudio.android.core.mvp.binding.rx.ui.BaseRxPresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.android.location.DefaultLocationInteractor
import ru.surfstudio.android.location.domain.LastKnownLocationRequest
import ru.surfstudio.android.location.domain.LocationPriority
import ru.surfstudio.android.location.location_errors_resolver.resolutions.impl.concrete.no_location_permission.LocationPermissionRequest
import javax.inject.Inject

/**
 * Презентер главного экрана
 */
@PerScreen
class MainPresenter @Inject constructor(
        basePresenterDependency: BasePresenterDependency,
        private val bm: MainBindModel,
        private val locationInteractor: DefaultLocationInteractor,
        private val locationPermissionRequest: LocationPermissionRequest,
        private val weatherInteractor: WeatherInteractor
) : BaseRxPresenter(basePresenterDependency) {

    private var locationDisposable = Disposables.disposed()
    private var loadWeatherDisposable = Disposables.disposed()

    override fun onFirstLoad() {
        safeGetLocation()
    }

    private fun safeGetLocation() {
        val lastKnowLocationRequest = LastKnownLocationRequest(
                LocationPriority.BALANCED_POWER_ACCURACY,
                true,
                locationPermissionRequest
        )

        locationDisposable.dispose()
        locationDisposable = subscribeIo(
                locationInteractor.observeLastKnownLocationWithErrorsResolution(lastKnowLocationRequest),
                { location ->
                    getWeatherData(location.latitude.toFloat(), location.longitude.toFloat())
                },
                { /* do nothing on complete */ },
                {
                    bm.loadState.accept(ErrorLoadState { })
                }
        )
    }

    private fun getWeatherData(lat: Float, lon: Float) {
        loadWeatherDisposable.dispose()
        loadWeatherDisposable = subscribeIoHandleError(
                weatherInteractor.getCurrentWeatherInfo(lat, lon),
                {
                    bm.weatherState.accept(it)
                },
                {
                    if (!bm.weatherState.hasValue) {
                        bm.loadState.accept(ErrorLoadState { getWeatherData(lat, lon) })
                    }
                }
        )
    }
}