package com.winnieweather.example.f_debug.fcm

import com.winnieweather.example.base.util.StringsProvider
import com.winnieweather.example.f_debug.R
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.android.logger.Logger
import com.winnieweather.example.i_push_notification.storage.FcmStorage
import javax.inject.Inject

/**
 * Презентер экрана показа fcm-токена
 */
@PerScreen
class FcmDebugPresenter @Inject constructor(
        basePresenterDependency: BasePresenterDependency,
        private val stringsProvider: StringsProvider,
        private val fcmStorage: FcmStorage
) : BasePresenter<FcmDebugActivityView>(basePresenterDependency) {

    private val sm = FcmDebugScreenModel()

    override fun onFirstLoad() {
        super.onFirstLoad()
        loadFcmToken()
    }

    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)
        view.render(sm)
    }

    fun loadFcmToken() {
        sm.fcmToken = fcmStorage.fcmToken
        view.render(sm)
        logFcmToken()
    }

    fun copyFcmToken() {
        sm.fcmToken?.let {
            view.copyFcmToken()
            view.showMessage(stringsProvider.getString(R.string.debug_fcm_copied_message))
            logFcmToken()
        }
    }

    private fun logFcmToken() {
        sm.fcmToken?.apply {
            if (isNotEmpty()) {
                Logger.d("FCM-token: $this")
            }
        }
    }
}
