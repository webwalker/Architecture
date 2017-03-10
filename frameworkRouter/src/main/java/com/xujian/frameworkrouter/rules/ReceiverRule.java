package com.xujian.frameworkrouter.rules;

import android.content.BroadcastReceiver;

import com.xujian.frameworkrouter.exception.ReceiverNotRouteException;

/**
 * receiver路由规则<br />
 * Created by xujian on 2017/3/10.
 */
public class ReceiverRule extends BaseIntentRule<BroadcastReceiver> {
    /**
     * receiver路由scheme
     */
    public static final String RECEIVER_SCHEME = "receiver://";

    @Override
    public void throwException(String pattern) {
        throw new ReceiverNotRouteException(pattern);
    }
}
