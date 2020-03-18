package plainness_software.com.appprototype.contract;

import java.util.List;

import plainness_software.com.appprototype.model.Movie;

public interface ProductListContract {

    interface Model
    {
        interface OnFinishedListener {
            void onFinished(List<Movie> productArrayList);

            void onFailure(Throwable t);
        }
        void getProductList(OnFinishedListener onFinishedListener, int pageNo);
    }
    interface View
    {
        void setDataToRecyclerView(List<Movie> productArrayList);
        void showProgress();
        void hideProgress();
        void onResponseFailure(Throwable throwable);
    }

    interface Presenters
    {
        void onDestroy();

        void requestDataFromServer();

    }
}
