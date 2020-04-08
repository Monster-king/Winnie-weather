package com.winnieweather.example.application.app.di

import com.winnieweather.example.application.app.App

/**
 * Объект ответственный за создание и хранение [AppComponent]
 */
object AppInjector {

    lateinit var appComponent: AppComponent

    fun initInjector(app: App) {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(app, app.activeActivityHolder))
                .build()
    }
}