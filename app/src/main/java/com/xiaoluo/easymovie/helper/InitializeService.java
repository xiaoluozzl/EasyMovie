package com.xiaoluo.easymovie.helper;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.squareup.leakcanary.LeakCanary;
import com.xiaoluo.easymovie.app.App;
import com.xiaoluo.easymovie.app.Constants;
import com.xiaoluo.easymovie.utils.CrashHandler;

import java.lang.reflect.Field;

/**
 * 子线程初始化
 *
 * author: xiaoluo
 * date: 2017/8/17 10:46
 */
public class InitializeService extends IntentService {
    private final static String TAG = InitializeService.class.getSimpleName();

    public InitializeService() {
        super(TAG);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, InitializeService.class);
        intent.setAction(TAG);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (TAG.equals(action)) {
                initApplication();
            }
        }
    }

    /**
     * 初始化
     */
    private void initApplication() {
        // Crash捕捉
        CrashHandler.getInstance().init(App.getInstance());

        // 内存泄漏分析
        LeakCanary.install(App.getInstance());

        // 获取屏幕数据
        getScreen();
    }

    /**
     * 获取屏幕数据
     */
    private void getScreen() {
        // 屏幕尺寸
        Point outSize = new Point();
        WindowManager windowManager = (WindowManager) App.getInstance().getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getSize(outSize);
        Constants.WIDTH_OF_SCREEN = outSize.x;
        Constants.HEIGHT_OF_SCREEN = outSize.y;

        // 状态栏高度
        Class<?> c;
        Object obj;
        Field field;
        int x, sbar = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            sbar = App.getInstance().getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        Constants.HEIGHT_OF_STATUSBAR = sbar;
    }
}
