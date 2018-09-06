package delivery.senstudio.ru.deliveryproject.common.net.api;

import delivery.senstudio.ru.deliveryproject.model.Stock;
import delivery.senstudio.ru.deliveryproject.model.Stocks;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("stocks.json")
    /*Call<GitHubModel> getSearchedRepos(@Query("date_req") String date);*/
   Call<Stocks> getStocks();
}
