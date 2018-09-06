package delivery.senstudio.ru.deliveryproject.common.net.component;

import javax.inject.Singleton;

import dagger.Component;
import delivery.senstudio.ru.deliveryproject.common.Activity.StocksActivity;
import delivery.senstudio.ru.deliveryproject.common.net.module.NetModule;

@Singleton
@Component(modules = {NetModule.class})
public interface NetComponent {
    void inject(StocksActivity activity);
}