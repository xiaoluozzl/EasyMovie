package com.xiaoluo.easymovie.base;

/**
 * Presenter基类
 *
 * author: xiaoluo
 * date: 2017/8/18 9:55
 */
public class BasePresenter<T extends BaseView> implements Presenter<T> {
    private T mBaseView;

    @Override
    public void attachView(T view) {
        mBaseView = view;
    }

    @Override
    public void detachView() {
        mBaseView = null;
    }

    public T getView() {
        return mBaseView;
    }

    public boolean isViewAttached() {
        return mBaseView != null;
    }
}
