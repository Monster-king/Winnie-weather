package com.winnieweather.example.ui.widget.di;

import ru.surfstudio.android.core.ui.activity.CoreActivityInterface;
import ru.surfstudio.android.mvp.widget.configurator.BaseWidgetViewConfigurator;
import ru.surfstudio.android.mvp.widget.delegate.ViewContextUnwrapper;

import com.winnieweather.example.ui.activity.di.ActivityComponent;

/**
 * Базовый конфигуратор для WidgetView
 */
public abstract class WidgetScreenConfigurator
        extends BaseWidgetViewConfigurator<ActivityComponent, WidgetScreenModule> {

    @Override
    protected WidgetScreenModule getWidgetScreenModule() {
        return new WidgetScreenModule(getPersistentScope());
    }

    @Override
    protected ActivityComponent getParentComponent() {
        return (ActivityComponent)
                ViewContextUnwrapper.unwrapContext(
                        getTargetWidgetView().getContext(),
                        CoreActivityInterface.class
                )
                        .getPersistentScope()
                        .getConfigurator()
                        .getActivityComponent();
    }
}