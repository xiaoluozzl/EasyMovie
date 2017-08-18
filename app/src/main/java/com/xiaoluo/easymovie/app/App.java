package com.xiaoluo.easymovie.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.xiaoluo.easymovie.helper.InitializeService;

import java.util.HashSet;
import java.util.Set;

/**
 * author: xiaoluo
 * date: 2017/8/17 10:22
 */
public class App extends Application {
    private static App sInstance;
    private Set<Activity> mAllActivities;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        // 子线程完成其它初始化
        InitializeService.start(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }


    /**
     * 添加Activity
     */
    public void addActivity(Activity activity) {
        if (mAllActivities == null) {
            mAllActivities = new HashSet<>();
        }
        mAllActivities.add(activity);
    }

    /**
     * 移除Activity
     */
    public void removeActivity(Activity activity) {
        if (mAllActivities != null) {
            mAllActivities.remove(activity);
        }
    }

    /**
     * 退出App
     */
    public void exitApp() {
        if (mAllActivities != null) {
            synchronized (mAllActivities) {
                for (Activity activity : mAllActivities) {
                    activity.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public static synchronized App getInstance() {
        return sInstance;
    }

}
