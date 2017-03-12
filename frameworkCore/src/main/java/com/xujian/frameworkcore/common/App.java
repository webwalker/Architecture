package com.xujian.frameworkcore.common;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.xujian.compiler.RouterHelper;

/**
 * Created by xujian on 2017/3/9.
 */
public class App extends android.support.multidex.MultiDexApplication {
    public static final String TAG = "Architecture";
    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static Application get() {
        return app;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        setupRouter();
    }

    private void setupRouter() {
        RouterHelper.install();
//        Router.addRouter(ActivityRule.VAR_ACTIVITY_SCHEME + "shop.main", ShopActivity.class);
//        Router.addRouter(ActivityRule.VAR_ACTIVITY_SCHEME + "bbs.main", BBSActivity.class);
    }
}
