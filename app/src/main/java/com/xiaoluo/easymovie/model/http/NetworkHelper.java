package com.xiaoluo.easymovie.model.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: xiaoluo
 * date: 2017/8/17 17:08
 */
public class NetworkHelper {
    private static NetworkHelper sInstance;
    private static final int DEFAULT_TIMEOUT = 15;
    private OkHttpClient mClient = new OkHttpClient();
    private DoubanApi mDoubanApi;

    public static NetworkHelper getInstance() {
        if (sInstance == null) {
            synchronized (NetworkHelper.class) {
                sInstance = new NetworkHelper();
            }
        }
        return sInstance;
    }

    private NetworkHelper() {
        initClient();
    }

    /**
     * 初始化OkHttpClient
     */
    private void initClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        mClient = builder.build();
    }

    /**
     * 豆瓣
     */
    public DoubanApi getDoubanApi() {
        if (mDoubanApi == null) {
            mDoubanApi = new Retrofit.Builder()
                    .client(mClient)
                    .baseUrl(DoubanApi.DOUBAN_HOST)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(DoubanApi.class);
        }
        return mDoubanApi;
    }

}
