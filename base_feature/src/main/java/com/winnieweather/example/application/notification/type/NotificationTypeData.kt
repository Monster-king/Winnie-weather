package com.winnieweather.example.application.notification.type

import ru.surfstudio.android.notification.interactor.push.BaseNotificationTypeData
import com.winnieweather.example.domain.notification.Notification

/**
 * Тип пуш уведомления с данными
 * todo изменить исходя из нужд приложения
 */
class NotificationTypeData : BaseNotificationTypeData<Notification>() {

    override fun extractData(map: Map<String, String>) = Notification()
}