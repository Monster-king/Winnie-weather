package com.winnieweather.example.application.notification

import ru.surfstudio.android.notification.ui.notification.AbstractPushHandleStrategyFactory
import ru.surfstudio.android.notification.ui.notification.strategies.PushHandleStrategy
import com.winnieweather.example.application.notification.strategy.BasePushHandleStrategy
import com.winnieweather.example.domain.notification.NotificationType
import java.util.*

/**
 * Фабрика стратегий обработки пуша по его типу
 */
object PushHandleStrategyFactory : AbstractPushHandleStrategyFactory() {
    override val map: HashMap<String, PushHandleStrategy<*>> = hashMapOf(
            NotificationType.UNKNOWN.id.toString() to BasePushHandleStrategy()
    )
}