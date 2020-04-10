package com.winnieweather.example.f_main.detail.controllers

import android.view.ViewGroup
import com.winnieweather.example.f_main.R
import kotlinx.android.synthetic.main.item_visibility.view.*
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class VisibilityItemController : BindableItemController<Long, VisibilityItemController.Holder>() {

    override fun getItemId(data: Long) = data.toString()

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    inner class Holder(parent: ViewGroup) : BindableViewHolder<Long>(parent, R.layout.item_visibility) {

        override fun bind(data: Long) {
            with(itemView) {
                visibility_tv.text = String.format("%.1f", data / 1000f)
                description_tv.text = "Average \uD83D\uDE0A"
            }
        }
    }
}