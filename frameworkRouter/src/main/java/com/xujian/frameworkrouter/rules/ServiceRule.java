package com.xujian.frameworkrouter.rules;

import android.app.Service;

import com.xujian.frameworkrouter.exception.ServiceNotRouteException;

/**
 * service路由规则<br />
 * Created by xujian on 2017/3/10.
 */
public class ServiceRule extends AbsIntentRule<Service> {
    @Override
    public void throwException(String pattern) {
        throw new ServiceNotRouteException(pattern);
    }
}
