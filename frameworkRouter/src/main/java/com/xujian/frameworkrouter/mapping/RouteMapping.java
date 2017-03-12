package com.xujian.frameworkrouter.mapping;

/**
 * 组件路由定义
 * Created by xujian on 2017/3/10.
 */
public class RouteMapping {
    public static final String ROOT_SCHEMA = "xujian://com.xujian.architecture";
    public static final String ACTIVITY_SCHEMA = ROOT_SCHEMA + "/activity/";
    public static final String SERVICE_SCHEMA = ROOT_SCHEMA + "/service/";
    public static final String RECEIVER_SCHEMA = ROOT_SCHEMA + "/receiver/";

    protected static String activity(String path) {
        return ACTIVITY_SCHEMA + path;
    }

    protected static String service(String path) {
        return SERVICE_SCHEMA + path;
    }

    protected static String receiver(String path) {
        return RECEIVER_SCHEMA + path;
    }
}