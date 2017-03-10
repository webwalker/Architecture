package com.xujian.frameworkrouter.exception;

/**
 * Created by xujian on 2017/3/10.
 */
public class ActivityNotRouteException extends NotRouteException {
    public ActivityNotRouteException(String pattern) {
        super("activity", pattern);
    }
}
