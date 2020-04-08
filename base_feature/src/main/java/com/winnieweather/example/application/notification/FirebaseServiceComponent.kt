package com.winnieweather.example.application.notification

import dagger.Component
import com.winnieweather.example.application.app.di.AppComponent
import com.winnieweather.example.i_push_notification.storage.FcmStorage
import javax.inject.Scope

@PerService
@Component(dependencies = [AppComponent::class])
interface FirebaseServiceComponent {

    fun fcmStorage(): FcmStorage

    fun inject(s: MessagingService)
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerService