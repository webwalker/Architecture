package com.xujian.frameworkrouter;

import android.net.Uri;
import android.text.TextUtils;

import java.io.Serializable;

/**
 * Created by xujian on 2017/3/10.
 */
public class RouteParams implements Serializable {
    private Uri uri;
    //调用时传递过去的，目标对象可以直接使用
    public final static String KEY = "route_key";

    public RouteParams(Uri uri) {
        this.uri = uri;
    }

    public RouteParams(String url) {
        this.uri = Uri.parse(url);
    }

    public static RouteParams newInstance(Uri uri) {
        return new RouteParams(uri);
    }

    public <T> T getValue(String key, Class<T> clzss) {
        if (uri == null) return (T) clzss;
        String value = uri.getQueryParameter(key);
        if (TextUtils.isEmpty(value)) {
            return (T) clzss;
        }
        return (T) value;
    }

    public String getValue(String key) {
        if (uri == null) return "";
        String value = uri.getQueryParameter(key);
        if (TextUtils.isEmpty(value)) return "";
        return value;
    }

    public int getIntValue(String key) {
        if (uri == null) return 0;
        String value = uri.getQueryParameter(key);
        if (TextUtils.isEmpty(value)) return 0;
        return Integer.parseInt(value);
    }

    public float getFloatValue(String key) {
        if (uri == null) return 0;
        String value = uri.getQueryParameter(key);
        if (TextUtils.isEmpty(value)) return 0;
        return Float.parseFloat(value);
    }

    public double getDoubleValue(String key) {
        if (uri == null) return 0;
        String value = uri.getQueryParameter(key);
        if (TextUtils.isEmpty(value)) return 0;
        return Double.parseDouble(value);
    }
}
