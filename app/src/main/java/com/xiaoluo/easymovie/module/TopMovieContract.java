package com.xiaoluo.easymovie.module;

import com.xiaoluo.easymovie.base.BaseView;
import com.xiaoluo.easymovie.model.MovieList;

import java.util.List;

/**
 * top250协议
 *
 * author: xiaoluo
 * date: 2017/8/18 10:06
 */
public interface TopMovieContract {
     interface ITopMovieView extends BaseView{
        void getMovieFail(String failMsg);
        void setMovieList(List<MovieList.SubjectsBean> list);
        void showLoading();
        void hideLoading();
    }

    interface ITopMoviePresenter {
        void getMovieList();
    }
}
