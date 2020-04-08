package com.winnieweather.example.application.network.di

import com.winnieweather.example.i_network.service.ServiceInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import ru.surfstudio.android.dagger.scope.PerApplication
import com.winnieweather.example.f_debug.DebugInteractor
import com.winnieweather.example.i_network.network.cache.SimpleCacheInterceptor
import com.winnieweather.example.i_network.network.etag.EtagInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Named

const val DI_NAME_SERVICE_INTERCEPTOR = "DI_NAME_SERVICE_INTERCEPTOR"
private const val NETWORK_TIMEOUT = 30L //sec

/**
 * этот модуль вынесен отдельно для возможности замены его при интеграционном тестировании
 */
@Module
class OkHttpModule {

    @Provides
    @PerApplication
    @Named(DI_NAME_SERVICE_INTERCEPTOR)
    internal fun provideServiceInterceptor(): Interceptor {
        return ServiceInterceptor()
    }

    @Provides
    @PerApplication
    internal fun provideOkHttpClient(
            @Named(DI_NAME_SERVICE_INTERCEPTOR) serviceInterceptor: Interceptor,
            cacheInterceptor: SimpleCacheInterceptor,
            etagInterceptor: EtagInterceptor,
            httpLoggingInterceptor: HttpLoggingInterceptor,
            debugInteractor: DebugInteractor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)

            debugInteractor.configureOkHttp(this)
            addInterceptor(cacheInterceptor)
            addInterceptor(etagInterceptor)
            addInterceptor(serviceInterceptor)
            addInterceptor(httpLoggingInterceptor)
        }.build()
    }
}