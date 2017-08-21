package com.xiaoluo.easymovie.module;

import com.xiaoluo.easymovie.base.BaseView;

/**
 * author: xiaoluo
 * date: 2017/8/21 9:52
 */
public interface TestContract {
    interface ITestView extends BaseView {
        void onTest();
        void onOver();
    }

    interface ITestPresenter{
        void onGet();
        void onOver();
    }
}
