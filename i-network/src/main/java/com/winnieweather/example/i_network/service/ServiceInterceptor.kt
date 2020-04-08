package com.winnieweather.example.i_network.service

import okhttp3.Interceptor
import okhttp3.Response
import ru.surfstudio.android.dagger.scope.PerApplication
import java.io.IOException
import javax.inject.Inject

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
        return chain.proceed(request)
    }
}
