package com.winnieweather.example.ui.placeholder.loadstate.state

import ru.surfstudio.android.core.mvp.loadstate.LoadStateInterface

class TransparentLoadingState : LoadStateInterface {
    override fun equals(other: Any?): Boolean {
        return other is TransparentLoadingState
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}