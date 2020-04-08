package com.winnieweather.example.ui.placeholder.loadstate.presentation

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import com.winnieweather.example.R
import kotlinx.android.synthetic.main.layout_state_empty.view.*
import ru.surfstudio.android.core.mvp.loadstate.SimpleLoadStatePresentation
import ru.surfstudio.android.custom.view.placeholder.PlaceHolderViewContainer
import ru.surfstudio.android.custom.view.placeholder.setClickableAndFocusable
import com.winnieweather.example.ui.placeholder.loadstate.state.EmptyLoadState

/**
 * Представление состояния EmptyLoadState, с картинкой, тайтлом, сабтайтлом и кнопкой
 */
class EmptyLoadStatePresentation(
        private val placeHolder: PlaceHolderViewContainer
) : SimpleLoadStatePresentation<EmptyLoadState>() {

    @StringRes
    var messageTextRes: Int = R.string.state_empty_text

    private lateinit var messageView: TextView

    private val view: View by lazy {
        LayoutInflater.from(placeHolder.context)
                .inflate(R.layout.layout_state_empty, placeHolder, false)
                .apply { messageView = empty_load_state_tv }
    }

    override fun showState(state: EmptyLoadState) {
        initViews(view)

        with(placeHolder) {
            changeViewTo(view)
            setClickableAndFocusable(true)
            show()
        }
    }

    private fun initViews(view: View) {
        messageView.text = view.context.getString(messageTextRes)
    }
}