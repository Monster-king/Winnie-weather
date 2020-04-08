package com.winnieweather.example.ui.placeholder

import com.winnieweather.example.ui.placeholder.loadstate.state.*
import ru.surfstudio.android.core.mvp.loadstate.LoadStateInterface

class NotFoundLoadState : LoadStateInterface
class NoInternetLoadState : LoadStateInterface

object LoadState {
    val NONE = NoneState()
    val MAIN_LOADING = MainLoadingState()
    val TRANSPARENT_LOADING = TransparentLoadingState()
    val ERROR = ErrorLoadState()
    val EMPTY = EmptyLoadState()
    val NOT_FOUND = NotFoundLoadState()
    val NO_INTERNET = NoInternetLoadState()
}