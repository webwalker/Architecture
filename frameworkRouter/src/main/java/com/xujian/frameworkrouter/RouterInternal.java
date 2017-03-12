package com.xujian.frameworkrouter;

import android.content.Context;

import com.xujian.frameworkrouter.exception.NotRouteException;
import com.xujian.frameworkrouter.mapping.RouteMapping;
import com.xujian.frameworkrouter.rules.ActivityRule;
import com.xujian.frameworkrouter.rules.ReceiverRule;
import com.xujian.frameworkrouter.rules.Rule;
import com.xujian.frameworkrouter.rules.ServiceRule;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by xujian on 2017/3/10.
 */
public class RouterInternal {
    private static RouterInternal sInstance;

    /**
     * scheme->路由规则
     */
    private HashMap<String, Rule> rules;

    private RouterInternal() {
        rules = new HashMap<>();
        initDefaultRouter();
    }

    /**
     * 添加默认Activity，Service，Receiver的Schema
     */
    private void initDefaultRouter() {
        addRule(RouteMapping.ACTIVITY_SCHEMA, new ActivityRule());
        addRule(RouteMapping.SERVICE_SCHEMA, new ServiceRule());
        addRule(RouteMapping.RECEIVER_SCHEMA, new ReceiverRule());
    }

    /*package */
    static RouterInternal get() {
        if (sInstance == null) {
            synchronized (RouterInternal.class) {
                if (sInstance == null) {
                    sInstance = new RouterInternal();
                }
            }
        }

        return sInstance;
    }

    /**
     * 添加自定义Schema
     *
     * @param scheme 路由scheme
     * @param rule   路由规则
     * @return {@code RouterInternal} Router真实调用类
     */
    public final RouterInternal addRule(String scheme, Rule rule) {
        rules.put(scheme, rule);
        return this;
    }

    private <T, V> Rule<T, V> getRule(String pattern) {
        HashMap<String, Rule> rules = this.rules;
        Set<String> keySet = rules.keySet();
        Rule<T, V> rule = null;
        for (String scheme : keySet) {
            if (pattern.startsWith(scheme)) {
                rule = rules.get(scheme);
                break;
            }
        }

        return rule;
    }

    /**
     * 添加Schema下的具体路由
     *
     * @param pattern 路由uri
     * @param klass   路由class
     * @return {@code RouterInternal} Router真实调用类
     */
    public final <T> RouterInternal addRouter(String pattern, Class<T> klass) {
        Rule<T, ?> rule = getRule(pattern);
        if (rule == null) {
            throw new NotRouteException("unknown", pattern);
        }

        rule.addRouter(pattern, klass);
        return this;
    }

    /**
     * 路由调用
     *
     * @param ctx     Context
     * @param pattern 路由uri
     * @return {@code V} 返回对应的返回值
     */
    /*package*/
    final <V> V invoke(Context ctx, String pattern) {
        Rule<?, V> rule = getRule(pattern);
        if (rule == null) {
            throw new NotRouteException("unknown", pattern);
        }

        return rule.invoke(ctx, pattern);
    }

    /**
     * 是否存在该路由
     *
     * @param pattern
     * @return
     */
    final boolean resolveRouter(String pattern) {
        Rule<?, ?> rule = getRule(pattern);
        return rule != null && rule.resolveRule(pattern);
    }
}
