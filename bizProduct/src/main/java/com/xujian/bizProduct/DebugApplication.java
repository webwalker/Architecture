package com.xujian.bizProduct;

import android.content.Context;

import com.xujian.annotation.Components;
import com.xujian.frameworkcore.common.App;

public class DebugApplication extends App {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
