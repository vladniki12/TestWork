package delivery.senstudio.ru.deliveryproject.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import delivery.senstudio.ru.deliveryproject.common.Activity.MainView;
import delivery.senstudio.ru.deliveryproject.model.Stock;

public interface StocksView extends MvpView, MainView {
    void showMessage(int message);

    void refreshDates(Stock[] dates);
}
