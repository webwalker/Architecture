package com.xujian.frameworkrouter.rules;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.xujian.frameworkrouter.RouteParams;
import com.xujian.frameworkrouter.exception.FragmentNotRouteException;
import com.xujian.frameworkrouter.support.RouteFragment;

import java.util.Set;

/**
 * Created by xujian on 2017/3/10.
 */
public class FragmentRule<T> extends AbsRule<T> implements Rule<T, RouteFragment> {
    @Override
    public void addRouter(String pattern, Class<T> klass) {
        intentRules.put(getPattern(pattern), klass);
    }

    @Override
    public RouteFragment invoke(Context ctx, String pattern) {
        Uri uri = Uri.parse(pattern);
        Class<T> klass = intentRules.get(getPattern(uri));
        if (klass == null) {
            throwException(pattern);
        }
        try {
            //存在查询参数时
            RouteFragment f = (RouteFragment) klass.newInstance();
            Bundle args = new Bundle();
            Set<String> names = uri.getQueryParameterNames();
            if (names != null && names.size() > 0) {
                for (String s : names) {
                    args.putString(s, uri.getQueryParameter(s));
                }
                //第二种传递方式
                //args.putSerializable(RouteParams.KEY, RouteParams.newInstance(uri));
            }
            f.setArguments(args);
            return f;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RouteFragment();
    }

    @Override
    public boolean resolveRule(String pattern) {
        return intentRules.get(pattern) != null;
    }

    @Override
    public void throwException(String pattern) {
        throw new FragmentNotRouteException(pattern);
    }
}
