package com.winnieweather.example.f_main.detail.controllers

import android.view.ViewGroup
import com.winnieweather.example.base.util.TWELVE_HOUR_PATTERN
import com.winnieweather.example.base.util.format
import com.winnieweather.example.base.util.toLocalDate
import com.winnieweather.example.domain.weather.SystemInfo
import com.winnieweather.example.f_main.R
import kotlinx.android.synthetic.main.item_sunset_time.view.*
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class SunsetTimeItemController : BindableItemController<SystemInfo, SunsetTimeItemController.Holder>() {

    override fun getItemId(data: SystemInfo) = data.hashCode().toString()

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    inner class Holder(parent: ViewGroup) : BindableViewHolder<SystemInfo>(parent, R.layout.item_sunset_time) {

        override fun bind(data: SystemInfo) {
            with(itemView) {
                sunrise_time_tv.text = data.sunrise.toLocalDate().format(TWELVE_HOUR_PATTERN)
                sunset_time_tv.text = data.sunset.toLocalDate().format(TWELVE_HOUR_PATTERN)
            }
        }
    }
}