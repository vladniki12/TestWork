package delivery.senstudio.ru.deliveryproject.presentaton;

import android.view.Menu;
import android.view.MenuInflater;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import delivery.senstudio.ru.deliveryproject.R;
import delivery.senstudio.ru.deliveryproject.common.net.api.API;
import delivery.senstudio.ru.deliveryproject.model.Stock;
import delivery.senstudio.ru.deliveryproject.model.Stocks;
import delivery.senstudio.ru.deliveryproject.view.StocksView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@InjectViewState
public class StocksPresentor extends MvpPresenter<StocksView> {

    Retrofit mRetrofit;

    List<String> mDateList = new ArrayList<>();

    long mCurrentTimeMillis = 0L;
    Calendar mCalendar = null;
    SimpleDateFormat mFormatter = null;

    public static int MAX_SIZE_ELEMENT = 30;

    public StocksPresentor() {

    }

    public void setRetrofit(Retrofit retrofit) {
        this.mRetrofit = retrofit;
    }


    public void updateStokcs() {
        getViewState().showLading();
        Call<Stocks> requestGetCurrency  =  mRetrofit.create(API.class).getStocks();

        requestGetCurrency.enqueue(new Callback<Stocks>() {
            @Override
            public void onResponse(Call<Stocks> call, Response<Stocks> response) {

                getViewState().hideLoading();
                if(response.body() != null) {

                    Stocks cur = response.body();


                    getViewState().refreshDates(cur.stocks);

                }
            }

            @Override
            public void onFailure(Call<Stocks> call, Throwable t) {

                getViewState().refreshDates(new Stock[0]);
                getViewState().hideLoading();
                getViewState().showMessage("");
            }
        });
    }



}
