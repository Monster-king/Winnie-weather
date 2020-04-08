package com.winnieweather.example.ui.placeholder.loadstate.presentation

import ru.surfstudio.android.core.mvp.loadstate.SimpleLoadStatePresentation
import ru.surfstudio.android.custom.view.placeholder.PlaceHolderViewContainer
import com.winnieweather.example.ui.placeholder.loadstate.state.NoneState

/**
 * Представление состояния NoneState, скрывающее PlaceHolderViewContainer
 */
class NoneLoadStatePresentation(
        private val placeHolder: PlaceHolderViewContainer
) : SimpleLoadStatePresentation<NoneState>() {

    override fun showState(state: NoneState) {
        with(placeHolder) {
            hide()
            removeAllViews()
        }
    }
}