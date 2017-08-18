package com.xiaoluo.easymovie.base;

/**
 * Presenter 基类接口
 *
 * author: xiaoluo
 * date: 2017/8/17 11:23
 */
public interface Presenter<V extends BaseView>{
    void attachView(V view);
    void detachView();
}
