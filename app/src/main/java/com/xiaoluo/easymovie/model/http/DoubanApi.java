package com.xiaoluo.easymovie.model.http;

import com.xiaoluo.easymovie.model.MovieList;

import retrofit2.http.GET;
import rx.Observable;

/**
 * author: xiaoluo
 * date: 2017/8/17 13:51
 */
public interface DoubanApi {
    String DOUBAN_HOST = "https://api.douban.com";

    @GET("/v2/movie/top250")
    Observable<MovieList> getTop250();
}
