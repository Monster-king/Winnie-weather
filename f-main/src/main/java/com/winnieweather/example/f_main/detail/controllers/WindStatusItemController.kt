package com.winnieweather.example.f_main.detail.controllers

import android.view.ViewGroup
import com.winnieweather.example.domain.weather.Wind
import com.winnieweather.example.f_main.R
import kotlinx.android.synthetic.main.item_wind_status.view.*
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class WindStatusItemController : BindableItemController<Wind, WindStatusItemController.Holder>() {

    override fun getItemId(data: Wind) = data.hashCode().toString()

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    inner class Holder(parent: ViewGroup) : BindableViewHolder<Wind>(parent, R.layout.item_wind_status) {

        override fun bind(data: Wind) {
            with(itemView) {
                wind_speed_tv.text = String.format("%.2f", data.speed * 3.6)
                direction_tv.text = "WSW" //todo calculate it
            }
        }
    }
}