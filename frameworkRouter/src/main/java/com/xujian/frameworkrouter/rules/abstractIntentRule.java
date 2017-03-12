package com.xujian.frameworkrouter.rules;

import android.content.Context;
import android.content.Intent;

import java.util.HashMap;

/**
 * 返回Intent的路由规则的基类<br />
 * Created by xujian on 2017/3/10.
 */
public abstract class abstractIntentRule<T> implements Rule<T, Intent> {
    private HashMap<String, Class<T>> intentRules;

    public abstractIntentRule() {
        intentRules = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addRouter(String pattern, Class<T> klass) {
        intentRules.put(pattern, klass);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Intent invoke(Context ctx, String pattern) {
        Class<T> klass = intentRules.get(pattern);
        if (klass == null) {
            throwException(pattern);
        }
        return new Intent(ctx, klass);
    }

    @Override
    public boolean resolveRule(String pattern) {
        return intentRules.get(pattern) != null;
    }

    /**
     * 当找不到路由规则时抛出异常
     *
     * @param pattern 路由pattern
     */
    public abstract void throwException(String pattern);
}