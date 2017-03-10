package com.xujian.frameworkrouter.exception;

/**
 * Created by xujian on 2017/3/10.
 */
public class NotRouteException extends RuntimeException {
    public NotRouteException(String name, String pattern) {
        super(String.format("%s cannot be resolved with pattern %s, have you declared it in your Router?",
                name, pattern));
    }
}
