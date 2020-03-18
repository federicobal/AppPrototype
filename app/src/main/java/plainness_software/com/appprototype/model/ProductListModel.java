package plainness_software.com.appprototype.model;

import android.util.Log;

import java.util.List;

import plainness_software.com.appprototype.contract.ProductListContract;
import plainness_software.com.appprototype.data.network.ApiInterface;
import plainness_software.com.appprototype.data.network.ApiNetwork;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static plainness_software.com.appprototype.data.network.ApiNetwork.API_KEY;

public class ProductListModel implements ProductListContract.Model
{
    private final String TAG = "ProductListModel";

    /*porque final onfinishedListerner ??*/
    @Override
    public void getProductList(final OnFinishedListener onFinishedListener, int pageNo) {
        ApiInterface apiService =
                ApiNetwork.getNetwork().create(ApiInterface.class);

        Call<ProductListResponse> call = apiService.getProducts(API_KEY, pageNo);
        call.enqueue(new Callback<ProductListResponse>() {
            @Override
            public void onResponse(Call<ProductListResponse> call, Response<ProductListResponse> response) {
                List<Movie> Products = response.body().getResults();
                Log.d(TAG, String.format("numero de Product recibidos: %d", Products.size()));
                onFinishedListener.onFinished(null);
            }

            @Override
            public void onFailure(Call<ProductListResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }
}
