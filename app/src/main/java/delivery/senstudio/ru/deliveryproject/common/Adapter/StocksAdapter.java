package delivery.senstudio.ru.deliveryproject.common.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import delivery.senstudio.ru.deliveryproject.R;
import delivery.senstudio.ru.deliveryproject.model.Stock;

public class StocksAdapter extends RecyclerView.Adapter<StocksAdapter.StockViewHolder> {


    Stock[] mStocks = null;
    private View.OnClickListener mOnClickListener = null;


    public StocksAdapter(Stock[] data, View.OnClickListener onClickListener) {
        this.mStocks = data;
        this.mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public StockViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewItemDate = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_stock_list, viewGroup, false);

        viewItemDate.setOnClickListener(mOnClickListener);
        StockViewHolder vh = new StockViewHolder(viewItemDate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder stockViewHolder, int i) {
        stockViewHolder.setTitleItem(mStocks[i].name);
        stockViewHolder.setAmountItem(String.valueOf(mStocks[i].price.amount));
        stockViewHolder.setVolumeItem(String.valueOf(mStocks[i].volume));


    }

    @Override
    public int getItemCount() {
        return mStocks.length;
    }

    public static class StockViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        @BindView(R.id.name_text_view)
        public TextView mNameTextView;

        @BindView(R.id.volume_text_view)
        public TextView mVolumeTextView;

        @BindView(R.id.amount_text_view)
        public TextView mAmountTextView;

        public StockViewHolder(View v) {
            super(v);
            ButterKnife.bind(this,v);

        }

        public void setTitleItem(String titleText) {
            mNameTextView.setText(titleText);
        }
        public void setVolumeItem(String titleText) {
            mVolumeTextView.setText(titleText);
        }
        public void setAmountItem(String titleText) {
            mAmountTextView.setText(titleText);
        }
    }
}
