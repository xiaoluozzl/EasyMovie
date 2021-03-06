package com.xiaoluo.easymovie.base;

/**
 * MVP Activity基类
 *
 * author: xiaoluo
 * date: 2017/8/17 11:22
 */
public abstract class BaseMVPActivity<T extends BasePresenter > extends BaseActivity implements BaseView {

    protected T mPresenter;

    /**
     * 初始化P,绑定V,P
     */
    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /**
     * 解除V和P的绑定
     */
    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    /**
     * 初始化Presenter
     */
    protected abstract void initPresenter();
}
