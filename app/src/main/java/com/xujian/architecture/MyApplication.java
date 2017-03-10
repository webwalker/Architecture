package com.xujian.architecture;

import android.content.Context;

import com.xujian.annotation.Components;
import com.xujian.frameworkcore.common.App;

/**
 * Created by xujian on 2017/3/10.
 */
@Components({"product", "order"})
public class MyApplication extends App {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
