package com.xujian.frameworkrouter.exception;

/**
 * Created by xujian on 2017/3/10.
 */
public class FragmentNotRouteException extends NotRouteException {
    public FragmentNotRouteException(String pattern) {
        super("fragment", pattern);
    }
}
