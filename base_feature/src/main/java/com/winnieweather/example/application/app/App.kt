package com.winnieweather.example.application.app

import android.content.Context
import android.content.Intent
import androidx.multidex.MultiDexApplication
import com.akaita.java.rxjava2debug.RxJava2Debug
import com.github.anrwatchdog.ANRWatchDog
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.winnieweather.example.BuildConfig.BUILD_TYPE
import com.winnieweather.example.R
import com.winnieweather.example.application.app.di.AppInjector
import com.winnieweather.example.application.logger.strategies.remote.FirebaseCrashlyticsRemoteLoggingStrategy
import com.winnieweather.example.application.logger.strategies.remote.RemoteLoggerLoggingStrategy
import com.winnieweather.example.base.logger.RemoteLogger
import com.winnieweather.example.f_debug.injector.DebugAppInjector
import io.reactivex.plugins.RxJavaPlugins
import ru.surfstudio.android.activity.holder.ActiveActivityHolder
import ru.surfstudio.android.logger.Logger
import ru.surfstudio.android.notification.ui.PushClickProvider
import ru.surfstudio.android.notification.ui.PushEventListener
import ru.surfstudio.android.utilktx.ktx.ui.activity.ActivityLifecycleListener
import com.winnieweather.example.application.logger.strategies.local.TimberLoggingStrategy

class App : MultiDexApplication() {

    val activeActivityHolder = ActiveActivityHolder()

    override fun onCreate() {
        super.onCreate()

        initAnrWatchDog()
        initLog()
        registerActiveActivityListener()

        RxJavaPlugins.setErrorHandler { Logger.e(it) }
        AppInjector.initInjector(this)
        DebugAppInjector.initInjector(this, activeActivityHolder)
        if (DebugAppInjector.debugInteractor.mustNotInitializeApp()) {
            // работает LeakCanary, ненужно ничего инициализировать
            return
        }

        //initFirebaseCrashlytics() todo uncoment for a real app
        initPushEventListener()
        initRxJava2Debug()

        DebugAppInjector.debugInteractor.onCreateApp(R.mipmap.ic_launcher)
    }

    /**
     * отслеживает ANR и отправляет в крашлитикс
     */
    private fun initAnrWatchDog() {
        ANRWatchDog().setReportMainThreadOnly()
                .setANRListener { RemoteLogger.logError(it) }
                .start()
    }

    private fun initLog() {
        Logger.addLoggingStrategy(TimberLoggingStrategy())
        Logger.addLoggingStrategy(RemoteLoggerLoggingStrategy())
        RemoteLogger.addRemoteLoggingStrategy(FirebaseCrashlyticsRemoteLoggingStrategy())
    }

    private fun initRxJava2Debug() {
        RxJava2Debug.enableRxJava2AssemblyTracking(arrayOf(packageName))
    }

    /**
     * Регистрирует слушатель аткивной активити
     */
    private fun registerActiveActivityListener() {
        registerActivityLifecycleCallbacks(
                ActivityLifecycleListener(
                        onActivityResumed = { activity ->
                            activeActivityHolder.activity = activity
                        },
                        onActivityPaused = {
                            activeActivityHolder.clearActivity()
                        }
                )
        )
    }

    private fun initFirebaseCrashlytics() {
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(isNotDebug())
    }

    private fun isNotDebug() = !BUILD_TYPE.contains("debug")

    private fun initPushEventListener() {
        PushClickProvider.pushEventListener = object : PushEventListener {
            override fun pushDismissListener(context: Context, intent: Intent) {
                //todo
            }

            override fun pushOpenListener(context: Context, intent: Intent) {
                //todo
            }
        }
    }
}