package com.xujian.frameworkrouter;

import android.content.Context;

import com.xujian.frameworkrouter.rules.Rule;

/**
 * Usage: <br />
 * <pre>
 * step 1. 调用Router.addRouter方法添加路由
 * step 2. 调用Router.invoke方法根据pattern调用路由
 * </pre>
 * Created by xujian on 2017/3/10.
 */
public class Router {
    /**
     * 添加自定义路由规则
     *
     * @param scheme 路由scheme
     * @param rule   路由规则
     * @return {@code RouterInternal} Router真实调用类
     */
    public static RouterInternal addRule(String scheme, Rule rule) {
        RouterInternal router = RouterInternal.get();
        router.addRule(scheme, rule);
        return router;
    }

    /**
     * 添加路由
     *
     * @param pattern 路由uri
     * @param klass   路由class
     * @return {@code RouterInternal} Router真实调用类
     */
    public static <T> RouterInternal addRouter(String pattern, Class<T> klass) {
        return RouterInternal.get().addRouter(pattern, klass);
    }

    /**
     * 路由调用
     *
     * @param ctx     Context
     * @param pattern 路由uri
     * @return {@code V} 返回对应的返回值
     */
    public static <V> V invoke(Context ctx, String pattern) {
        return RouterInternal.get().invoke(ctx, pattern);
    }

    /**
     * 是否存在该路由
     *
     * @param pattern
     * @return
     */
    public static boolean resolveRouter(String pattern) {
        return RouterInternal.get().resolveRouter(pattern);
    }
}
