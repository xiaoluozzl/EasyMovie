package com.xiaoluo.easymovie.model;

import com.xiaoluo.easymovie.model.http.NetworkHelper;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 数据管理
 * 统一负责网络数据和数据库
 *
 * author: xiaoluo
 * date: 2017/8/17 13:55
 */
public class DataManager {

    private static DataManager sInstance;

    public DataManager() {

    }

    public static DataManager getInstance() {
        if (sInstance == null) {
            synchronized (DataManager.class) {
                sInstance = new DataManager();
            }
        }
        return sInstance;
    }

    public Subscription getTop250(Subscriber<List<MovieList.SubjectsBean>> subscriber) {
        return NetworkHelper.getInstance().getDoubanApi()
                .getTop250()
                .map(new Func1<MovieList, List<MovieList.SubjectsBean>>() {
                    @Override
                    public List<MovieList.SubjectsBean> call(MovieList movieList) {
                        return movieList.getSubjects();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
