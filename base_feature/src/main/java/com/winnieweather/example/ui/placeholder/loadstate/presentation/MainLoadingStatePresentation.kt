package com.winnieweather.example.ui.placeholder.loadstate.presentation

import android.view.LayoutInflater
import android.view.View
import com.winnieweather.example.R
import ru.surfstudio.android.core.mvp.loadstate.SimpleLoadStatePresentation
import ru.surfstudio.android.custom.view.placeholder.PlaceHolderViewContainer
import ru.surfstudio.android.custom.view.placeholder.setClickableAndFocusable
import com.winnieweather.example.ui.placeholder.loadstate.state.MainLoadingState

/**
 * Представление состояния MainLoading в виде ProgressBar
 */
class MainLoadingStatePresentation(
        private val placeHolder: PlaceHolderViewContainer
) : SimpleLoadStatePresentation<MainLoadingState>() {

    private val view: View by lazy {
        LayoutInflater.from(placeHolder.context).inflate(R.layout.layout_load_state, placeHolder, false)
    }

    override fun showState(state: MainLoadingState) {
        with(placeHolder) {
            changeViewTo(view)
            setClickableAndFocusable(true)
            show()
        }
    }
}