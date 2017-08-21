package com.xiaoluo.easymovie.module;

import com.xiaoluo.easymovie.base.BasePresenter;

/**
 * author: xiaoluo
 * date: 2017/8/21 9:51
 */
public class TestPresenter extends BasePresenter<TestContract.ITestView> implements TestContract.ITestPresenter {
    @Override
    public void onGet() {
        if (isViewAttached()) {
            getView().onTest();
        }
    }

    @Override
    public void onOver() {
        if (isViewAttached()) {
            getView().onOver();
        }
    }


}
