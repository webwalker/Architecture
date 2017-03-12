package com.xujian.frameworkrouter.rules;

import android.content.BroadcastReceiver;

import com.xujian.frameworkrouter.exception.ReceiverNotRouteException;

/**
 * receiver路由规则<br />
 * Created by xujian on 2017/3/10.
 */
public class ReceiverRule extends abstractIntentRule<BroadcastReceiver> {
    @Override
    public void throwException(String pattern) {
        throw new ReceiverNotRouteException(pattern);
    }
}
