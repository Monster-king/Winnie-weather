package com.winnieweather.example.i_weather

import com.winnieweather.example.domain.weather.WeatherInfo
import com.winnieweather.example.i_network.network.BaseNetworkInteractor
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import ru.surfstudio.android.connection.ConnectionProvider
import ru.surfstudio.android.dagger.scope.PerApplication
import javax.inject.Inject

/**
 * Интерактор погоды
 */
@PerApplication
class WeatherInteractor @Inject constructor(
        connectionProvider: ConnectionProvider,
        private val weatherRepository: WeatherRepository
) : BaseNetworkInteractor(connectionProvider) {

    private val weatherInfoSubject = PublishSubject.create<WeatherInfo>()
    val weatherInfoObservable = weatherInfoSubject.hide()

    /**
     * Возвращает текущую информацию погоды по заданной геолокации
     *
     * @param lat широта (latitude) местоположения
     * @param lon долгота (longitude) местоположения
     */
    fun getCurrentWeatherInfo(lat: Float, lon: Float): Single<WeatherInfo> {
        return weatherRepository.getCurrentWeatherInfo(lat, lon)
                .doOnSuccess {
                    weatherInfoSubject.onNext(it)
                }
    }
}