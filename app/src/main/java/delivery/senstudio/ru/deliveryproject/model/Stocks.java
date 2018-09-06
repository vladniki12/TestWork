package delivery.senstudio.ru.deliveryproject.model;

import com.google.gson.annotations.SerializedName;

public class Stocks {

    @SerializedName("stock")
    public final Stock[] stocks;

    public Stocks(Stock[] stocks) {
        this.stocks = stocks;
    }
}
