package plainness_software.com.appprototype.data.network;

import plainness_software.com.appprototype.model.ProductListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

//    @GET("product/list")
    @GET("movie/popular")
    Call<ProductListResponse> getProducts(@Query("api_key") String apiKey, @Query("page") int PageNo);

//    //@GET("product/{product_id}")
//    @GET("movie/{movie_id}")
//    Call<ProductListItemModel> getproductDetails(@Path("product_id") int productId, @Query("api_key") String apiKey, @Query("append_to_response") String description);

}