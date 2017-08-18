package com.xiaoluo.easymovie.module.movie;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xiaoluo.easymovie.R;
import com.xiaoluo.easymovie.adapter.TopMovieAdapter;
import com.xiaoluo.easymovie.base.BaseFragment;
import com.xiaoluo.easymovie.model.MovieList;
import com.xiaoluo.easymovie.module.TopMovieContract;
import com.xiaoluo.easymovie.module.TopMoviePresenter;
import com.xiaoluo.easymovie.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 电影:top250
 *
 * author: xiaoluo
 * date: 2017/8/18 16:22
 */
public class TopMovieFragment extends BaseFragment implements TopMovieContract.ITopMovieView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private TopMoviePresenter mPresenter;
    private TopMovieAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private List<MovieList.SubjectsBean> mList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_top_movie;
    }

    @Override
    protected void initEvent() {
        mAdapter = new TopMovieAdapter(mList);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        mPresenter = new TopMoviePresenter();
        mPresenter.attachView(this);

        mPresenter.getMovieList();
    }

    @Override
    public void getMovieFail(String failMsg) {
        Utils.showToast(failMsg);
    }

    @Override
    public void setMovieList(List<MovieList.SubjectsBean> list) {
        mAdapter.setList(list);
    }

    @Override
    public void showLoading() {
        Utils.showToast("加载中");
    }

    @Override
    public void hideLoading() {
        Utils.showToast("加载完成");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
