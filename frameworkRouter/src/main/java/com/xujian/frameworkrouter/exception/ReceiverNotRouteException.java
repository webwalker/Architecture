package com.xujian.frameworkrouter.exception;

/**
 * Created by xujian on 2017/3/10.
 */
public class ReceiverNotRouteException extends NotRouteException {
    public ReceiverNotRouteException(String pattern) {
        super("receiver", pattern);
    }
}
