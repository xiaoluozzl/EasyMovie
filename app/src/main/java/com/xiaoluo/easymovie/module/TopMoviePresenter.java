package com.xiaoluo.easymovie.module;

import com.xiaoluo.easymovie.base.BasePresenter;
import com.xiaoluo.easymovie.model.DataManager;
import com.xiaoluo.easymovie.model.MovieList;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

import static com.xiaoluo.easymovie.module.TopMovieContract.ITopMoviePresenter;
import static com.xiaoluo.easymovie.module.TopMovieContract.ITopMovieView;

/**
 * top250
 *
 * author: xiaoluo
 * date: 2017/8/18 10:05
 */
public class TopMoviePresenter extends BasePresenter<ITopMovieView> implements ITopMoviePresenter {

    private Subscription mSubscription;

    @Override
    public void getMovieList() {
        getView().showLoading();
        mSubscription = DataManager.getInstance().
                getTop250(new Subscriber<List<MovieList.SubjectsBean>>() {
                    @Override
                    public void onCompleted() {
                        getView().hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().hideLoading();
                        getView().getMovieFail(e.toString());
                    }

                    @Override
                    public void onNext(List<MovieList.SubjectsBean> list) {
                        getView().setMovieList(list);
                    }
                });
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null && !mSubscription.isUnsubscribed())
            mSubscription.unsubscribe();
    }
}
