package com.xiaoluo.easymovie.base;

/**
 * author: xiaoluo
 * date: 2017/8/21 11:00
 */
public abstract class BaseMVPFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

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
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();

        }
        super.onDestroyView();
    }

    /**
     * 初始化Presenter
     */
    protected abstract void initPresenter();
}
