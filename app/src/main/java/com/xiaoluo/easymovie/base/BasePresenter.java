package com.xiaoluo.easymovie.base;

/**
 * Presenter基类
 *
 * author: xiaoluo
 * date: 2017/8/18 9:55
 */
public class BasePresenter<T extends BaseView> implements Presenter<T> {
    private T mBaseView;

    /**
     * 绑定V,P
     */
    @Override
    public void attachView(T view) {
        mBaseView = view;
    }

    /**
     * 释放V层
     */
    @Override
    public void detachView() {
        mBaseView = null;
    }

    /**
     * 获取V
     */
    public T getView() {
        return mBaseView;
    }

    /**
     * 判断V是否已绑定
     * 调用V层时,最好进行判断
     */
    public boolean isViewAttached() {
        return mBaseView != null;
    }
}
