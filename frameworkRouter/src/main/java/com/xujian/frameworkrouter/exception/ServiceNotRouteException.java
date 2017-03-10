package com.xujian.frameworkrouter.exception;

/**
 * Created by xujian on 2017/3/10.
 */
public class ServiceNotRouteException extends NotRouteException {
    public ServiceNotRouteException(String pattern) {
        super("service", pattern);
    }
}
