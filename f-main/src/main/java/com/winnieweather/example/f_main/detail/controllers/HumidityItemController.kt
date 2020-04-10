package com.winnieweather.example.f_main.detail.controllers

import android.view.ViewGroup
import com.winnieweather.example.f_main.R
import kotlinx.android.synthetic.main.item_humidity.view.*
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class HumidityItemController : BindableItemController<Int, HumidityItemController.Holder>() {

    override fun getItemId(data: Int) = data.toString()

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    inner class Holder(parent: ViewGroup) : BindableViewHolder<Int>(parent, R.layout.item_humidity) {

        override fun bind(data: Int) {
            with(itemView) {
                humidity_tv.text = data.toString()
                progress_dot_view.progress = data
            }
        }
    }
}