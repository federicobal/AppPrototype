package plainness_software.com.appprototype.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import plainness_software.com.appprototype.R;
import plainness_software.com.appprototype.adapter.ProductListAdapter;
import plainness_software.com.appprototype.contract.ProductListContract;
import plainness_software.com.appprototype.model.Movie;
import plainness_software.com.appprototype.model.ProductListModel;
import plainness_software.com.appprototype.presenter.ProductListPresenter;
import plainness_software.com.appprototype.util.GridSpacingItemDecoration;

import static plainness_software.com.appprototype.util.GridSpacingItemDecoration.dpToPx;

public class ProductListActivity extends AppCompatActivity implements ProductListContract.View,ShowEmptyView
{
//        , ProductItemClickListener,
//        ShowEmptyView

    private static final String TAG = "ProductListActivity";
    private ProductListPresenter productListPresenter;
    private RecyclerView rvProduct;
    private List<Movie> productList;
//    private ProgressBar pbLoading;
    private ProductListAdapter productListAdapter;
    private GridLayoutManager mLayoutManager;
    private TextView tvEmptyView;

    private int pageNo = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        InitUi();
        //setListeners();
        //Initializing presenter
        Log.d("ProductListActivity", (String)"llegue1");
        productListPresenter = new ProductListPresenter(this);

        productListPresenter.requestDataFromServer();
    }
    public void InitUi()
    {
        //getSupportActionBar().setTitle(getString(R.string.most_popular_product));
        rvProduct= findViewById(R.id.rvProduct);
        productList = new ArrayList<>();
        productListAdapter = new ProductListAdapter(this,productList);
//
        mLayoutManager = new GridLayoutManager(this, 2);
        rvProduct.setLayoutManager(mLayoutManager);
        rvProduct.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(this, 10), true));
        rvProduct.setItemAnimator(new DefaultItemAnimator());
        rvProduct.setAdapter(productListAdapter);
        Toast.makeText(this, "PASÉ POR AQUÍ", Toast.LENGTH_LONG).show();
//        pbLoading = findViewById(R.id.pb_loading);

    }
    @Override
    public void setDataToRecyclerView(List<Movie> productArrayList) {
        productList.addAll(productArrayList);
        productListAdapter.notifyDataSetChanged();

        // This will help us to fetch data from next page no.
        pageNo++;

    }
//
//    @Override
//    public void onResponseFailure(Throwable throwable) {
//
//        Log.e(TAG, throwable.getMessage());
//        //getString(R.string.communication_error
//        //Toast.makeText(this,throwable.getMessage(), Toast.LENGTH_LONG).show();
//    }
//
    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onResponseFailure(Throwable throwable) {

        Log.e(TAG, throwable.getMessage());
        //Toast.makeText(this, getString(R.string.communication_error), Toast.LENGTH_LONG).show();
    }
    @Override
    public void showEmptyView() {

        rvProduct.setVisibility(View.GONE);
        tvEmptyView.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideEmptyView() {
        rvProduct.setVisibility(View.VISIBLE);
        tvEmptyView.setVisibility(View.GONE);
    }
}
