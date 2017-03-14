package com.xujian.frameworkrouter.rules;

import android.net.Uri;

import java.util.HashMap;

/**
 * Created by xujian on 2017/3/10.
 */
public abstract class AbsRule<T> {
    protected HashMap<String, Class<T>> intentRules;

    public AbsRule() {
        intentRules = new HashMap<>();
    }

    /**
     * 获取主要信息作为路由规则
     *
     * @param uri
     * @return
     */
    protected String getPattern(Uri uri) {
        return uri.getScheme() + "://" + uri.getHost() + uri.getPath();
    }

    /**
     * 获取主要信息作为路由规则
     *
     * @param pattern
     * @return
     */
    protected String getPattern(String pattern) {
        Uri uri = Uri.parse(pattern);
        return uri.getScheme() + "://" + uri.getHost() + uri.getPath();
    }
}
