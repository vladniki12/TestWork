package delivery.senstudio.ru.deliveryproject.common.Activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import delivery.senstudio.ru.deliveryproject.App;
import delivery.senstudio.ru.deliveryproject.R;
import delivery.senstudio.ru.deliveryproject.common.Adapter.StocksAdapter;
import delivery.senstudio.ru.deliveryproject.model.Stock;
import delivery.senstudio.ru.deliveryproject.presentaton.StocksPresentor;
import delivery.senstudio.ru.deliveryproject.view.StocksView;
import retrofit2.Retrofit;

public class StocksActivity extends MainAppActivity implements StocksView {




    @InjectPresenter
    StocksPresentor mStocksPresentor;

    @Inject
    Retrofit mRetrofit;

    @BindView(R.id.date_recycler_view)
    RecyclerView mDateRecyclerView;

    @BindView(R.id.date_toolbar)
    Toolbar mTollBarView;


    LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_activity);

        ButterKnife.bind(this);

        ((App) getApplication()).getNetComponent().inject(this);

        mDateRecyclerView.setLayoutManager(mLayoutManager);

        mStocksPresentor.setRetrofit(mRetrofit);

        setSupportActionBar(mTollBarView);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);



        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                mStocksPresentor.updateStokcs();

                handler.postDelayed(this, 5000);
            }
        };

        handler.post(runnable);

    }




    @Override
    public void showMessage(int message) {
        //test.setText(String.valueOf(message));
    }

    @Override
    public void refreshDates(Stock[] dates) {

        StocksAdapter stocksAdapter = new StocksAdapter(dates, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        mDateRecyclerView.setAdapter(stocksAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.app_bar, menu);
        return true;
    }
    //and this to handle actions
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            mStocksPresentor.updateStokcs();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
