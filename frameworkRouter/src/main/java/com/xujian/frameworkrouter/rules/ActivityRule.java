package com.xujian.frameworkrouter.rules;

import android.app.Activity;

import com.xujian.frameworkrouter.exception.ActivityNotRouteException;

/**
 * activity路由规则<br />
 * Created by xujian on 2017/3/10.
 */
public class ActivityRule extends AbsIntentRule<Activity> {
    /**
     * {@inheritDoc}
     */
    @Override
    public void throwException(String pattern) {
        throw new ActivityNotRouteException(pattern);
    }
}
