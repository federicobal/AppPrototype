package plainness_software.com.appprototype.presenter;

import android.util.Log;

import java.util.List;

import plainness_software.com.appprototype.contract.ProductListContract;
import plainness_software.com.appprototype.model.Movie;
import plainness_software.com.appprototype.model.ProductListModel;

public class ProductListPresenter implements ProductListContract.Presenters, ProductListContract.Model.OnFinishedListener
{
    private ProductListContract.View productListView;
    private ProductListContract.Model productListModel;

    public ProductListPresenter(ProductListContract.View productListView) {
        Log.d("ProductListPresenter", (String)"llegue1");
        this.productListView = productListView;
        Log.d("ProductListPresenter", (String)"llegue2");
        productListModel = new ProductListModel();
        Log.d("ProductListPresenter", (String)"llegue3");

    }
    @Override
    public void onDestroy() {

    }

    @Override
    public void requestDataFromServer() {
        if (productListView != null) {
            productListView.showProgress();
        }
        productListModel.getProductList(this, 1);
    }

    @Override
    public void onFinished(List<Movie> productArrayList) {
        productListView.setDataToRecyclerView(productArrayList);
        if (productListView != null) {
            productListView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        productListView.onResponseFailure(t);
        if (productListView != null) {
            productListView.hideProgress();
        }
    }
}