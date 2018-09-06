package delivery.senstudio.ru.deliveryproject.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class Stock {

    @SerializedName("name")
    public final String name;

    @SerializedName("volume")
    public final int volume;

    @SerializedName("price")
    public final Price price;


    public Stock(String name, int volume,  Price price) {
        this.name = name;
        this.volume = volume;
        this.price = price;

    }

    public class Price {
        @SerializedName("amount")
        public final float amount;

        public Price(float amount){
            this.amount = Float.parseFloat(String.format("%.2f", amount));;
        }

    }
}
