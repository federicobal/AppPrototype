package plainness_software.com.appprototype.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import plainness_software.com.appprototype.R;
import plainness_software.com.appprototype.model.ProductListModel;
import plainness_software.com.appprototype.ui.ProductListActivity;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> implements Filterable
{
    private ProductListActivity productListActivity;
    private List<ProductListModel> productList;
    private List<ProductListModel> originalProductList;

    private String fromDate;
    private String toDate;

    public ProductListAdapter(ProductListActivity productListActivity, List<ProductListModel> productList) {
        this.productListActivity = productListActivity;
        this.productList = productList;
        this.originalProductList = productList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //return null;
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_product_list_card, parent, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
    }
    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                List<ProductListModel> filteredResults = null;
                if (fromDate.isEmpty() || toDate.isEmpty()) {
                    filteredResults = originalProductList;
                } else {
                    filteredResults = originalProductList;//getFilteredResults(fromDate, toDate);
                }

                FilterResults results = new FilterResults();
                results.values = filteredResults;

                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                productList = (List<ProductListModel>) filterResults.values;
                ProductListAdapter.this.notifyDataSetChanged();

                if (getItemCount() == 0) {
//                    productListActivity.showEmptyView();
                } else {
//                    productListActivity.hideEmptyView();
                }
            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //        public TextView tvMovieTitle;
//
//        public TextView tvMovieRatings;
        public TextView tvReleaseDate;
        //        public ImageView ivMovieThumb;
        public ProgressBar pbLoadImage;
        public MyViewHolder(View itemView) {
            super(itemView);
            //tvMovieTitle = itemView.findViewById(R.id.tv_movie_title);
            tvReleaseDate = itemView.findViewById(R.id.tv_release_date);
//            tvMovieRatings = itemView.findViewById(R.id.tv_movie_ratings);
//            ivMovieThumb = itemView.findViewById(R.id.iv_movie_thumb);
            pbLoadImage = itemView.findViewById(R.id.pb_load_image);
        }
    }
}