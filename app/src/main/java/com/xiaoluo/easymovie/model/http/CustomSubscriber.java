package com.xiaoluo.easymovie.model.http;

import rx.Subscriber;

/**
 * 自定义订阅
 *
 * author: xiaoluo
 * date: 2017/8/17 17:54
 */
public abstract class CustomSubscriber<T> extends Subscriber<T> {
    private final static String TAG = CustomSubscriber.class.getSimpleName();

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onNext(T t) {
        requestSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
//        if (e instanceof SocketTimeoutException) {
//            Utils.showToast("");
//        } else if (e instanceof ConnectException) {
////            Utils.showToast(mContext.getResources().getString(R.string.error_network));
//        } else if (e instanceof APIException) {
//            // 自定义错误
//            Utils.showToast(e.getMessage());
//        } else {
//            Utils.showToast("NET ERROR : " + e.getMessage());
//        }

        requestError(e.getMessage());
    }

    /**
     * 请求成功回调
     */
    protected abstract void requestSuccess(T t);

    /**
     * 请求失败回调
     */
    protected abstract void requestError(String error);

}
