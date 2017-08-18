package com.xiaoluo.easymovie.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Fragment基类
 *
 * author: xiaoluo
 * date: 2017/8/18 16:06
 */
public abstract class BaseFragment extends android.support.v4.app.Fragment {
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        int resId = getLayoutId();
        if (resId != 0) {
            return inflater.inflate(resId, container, false);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        initEvent();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    /**
     * 加载页面布局
     *
     * @return layoutResId 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化
     */
    protected abstract void initEvent();
}
