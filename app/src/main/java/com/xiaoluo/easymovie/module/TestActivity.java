package com.xiaoluo.easymovie.module;

import android.os.Handler;
import android.widget.Toast;

import com.xiaoluo.easymovie.R;
import com.xiaoluo.easymovie.base.BaseMVPActivity;

/**
 * author: xiaoluo
 * date: 2017/8/21 9:51
 */
public class TestActivity extends BaseMVPActivity<TestPresenter> implements TestContract.ITestView {

    Handler handler;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initEvent() {
        mPresenter.onGet();
    }

    @Override
    public void onTest() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mContext, "test", Toast.LENGTH_SHORT).show();
                mPresenter.onOver();
            }
        }, 3000);

    }

    @Override
    public void onOver() {
        Toast.makeText(mContext, "over", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initPresenter() {
        mPresenter = new TestPresenter();
    }
}
