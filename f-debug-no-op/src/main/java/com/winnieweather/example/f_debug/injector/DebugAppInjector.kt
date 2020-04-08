package com.winnieweather.example.f_debug.injector

import android.app.Application
import ru.surfstudio.android.activity.holder.ActiveActivityHolder
import com.winnieweather.example.f_debug.DebugInteractor

object DebugAppInjector {

    lateinit var debugInteractor: DebugInteractor

    fun initInjector(app: Application, activeActivityHolder: ActiveActivityHolder) {
        debugInteractor = DebugInteractor()
    }
}