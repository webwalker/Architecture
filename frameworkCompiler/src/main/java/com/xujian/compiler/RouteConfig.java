package com.xujian.compiler;

/**
 * Created by xujian on 2017/3/10.
 */
public class RouteConfig {
    //路由模块所在的包名
    public static final String PACKAGE_NAME = "com.xujian.frameworkrouter";
    public static final String FILE_PREFIX = "Router_";
    public static final String ROUTER_MANAGER = "RouterManager";
    public static final String ROUTER_MANAGER_METHOD = "setup";
    //public static final String ROUTER_METHOD_NAME = PACKAGE_NAME + ".Router.addRouter";
    public static final String ROUTER_METHOD_NAME = "Router.addRouter";
    //    public static final String VAR_ACTIVITY_SCHEME = PACKAGE_NAME + ".RouteMapping.ACTIVITY_SCHEMA";
//    public static final String VAR_SERVICE_SCHEME = PACKAGE_NAME + ".RouteMapping.SERVICE_SCHEMA";
//    public static final String VAR_RECEIVER_SCHEME = PACKAGE_NAME + ".RouteMapping.RECEIVER_SCHEMA";
    public static final String VAR_ACTIVITY_SCHEME = "RouteMapping.ACTIVITY_SCHEMA";
    public static final String VAR_SERVICE_SCHEME = "RouteMapping.SERVICE_SCHEMA";
    public static final String VAR_RECEIVER_SCHEME = "RouteMapping.RECEIVER_SCHEMA";
}
