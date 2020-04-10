package com.winnieweather.example.i_network.service

import com.winnieweather.example.base.util.defaultLocale
import okhttp3.Interceptor
import okhttp3.Response
import ru.surfstudio.android.dagger.scope.PerApplication
import java.io.IOException
import javax.inject.Inject

private const val LOCALE_HEADER = "Content-Language"

/**
 * добавляет необходимые для каждого запроса параметры, такие как token
 */
@PerApplication
class ServiceInterceptor @Inject constructor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val request = originalRequest.newBuilder()
                .build()

        val headersBuilder = originalRequest.headers().newBuilder()
                .add(LOCALE_HEADER, defaultLocale.language)

        return chain.proceed(request)
    }
}
