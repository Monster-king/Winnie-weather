package com.winnieweather.example.ui.placeholder.loadstate.state

import ru.surfstudio.android.core.mvp.loadstate.LoadStateInterface

class NoneState : LoadStateInterface {
    override fun equals(other: Any?): Boolean {
        return other is NoneState
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}