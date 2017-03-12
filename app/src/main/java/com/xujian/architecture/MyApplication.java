package com.xujian.architecture;

import android.content.Context;

import com.xujian.annotation.Components;
import com.xujian.frameworkcore.common.App;
import com.xujian.frameworkrouter.mapping.Compontents;

/**
 * 从apt编译的过程来看，在各个业务组件中使用注解@Component(“”)，然后processor的时候再去查找所有业务组件库中包含该注解的类，
 * 然后编译生成包含该注解的路由方法初始化，每个组件包都这样生成类，没法统一初始化和管理，不可行；
 * 所以可提供总的注入入口(Compontents或者自定义的String数组)，统一注入所有组件库路由的初始化过程。
 * 每个组件的初始化过程都去调用各自的路由规则映射处理。
 * 过多的Activity会导致很多的Compontent参数定义
 * Created by xujian on 2017/3/10.
 */
@Components({Compontents.PRODUCT, Compontents.ORDER})
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
