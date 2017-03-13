package com.xujian.frameworkrouter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import com.xujian.frameworkrouter.mapping.RouteMapping;

import java.util.List;
import java.util.Set;

/**
 * 通过在Activity、Service、BroadcastReceiver中定义data来路由跳转
 * <intent-filter>
 * <data android:host="com.xujian.architecture" android:path="/activity/someWorks" android:scheme="xujian"/>
 * <category android:name="android.intent.category.DEFAULT"/>
 * <category android:name="android.intent.category.BROWSABLE"/>
 * </intent-filter>
 * Created by xujian on 2017/3/10.
 */
public class RouterEx {
    public final static String ACTIVITY_TEST = RouteMapping.ACTIVITY_SCHEMA + "/activity/someWorks?a=b";
    public final static String SERVICE_TEST = RouteMapping.SERVICE_SCHEMA + "/service/someWorks?a=b";
    public final static String RECEIVER_TEST = RouteMapping.RECEIVER_SCHEMA + "/receiver/someWorks?a=b";

    /**
     * 路由分发
     *
     * @param ctx
     * @param url data url
     * @return
     */
    public static Intent invoke(Context ctx, String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PackageManager packageManager = ctx.getPackageManager();
        List<ResolveInfo> lists = null;
        if (url.startsWith(RouteMapping.ACTIVITY_SCHEMA)) {
            lists = packageManager.queryIntentActivities(intent, 0);
        } else if (url.startsWith(RouteMapping.SERVICE_SCHEMA)) {
            lists = packageManager.queryIntentServices(intent, 0);
        } else if (url.startsWith(RouteMapping.RECEIVER_SCHEMA)) {
            lists = packageManager.queryBroadcastReceivers(intent, 0);
        }
        if (lists != null && !lists.isEmpty()) {
            //将Schema中的参数放到Intent中
            Set<String> names = uri.getQueryParameterNames();
            if (names != null && names.size() > 0) {
                for (String s : names) {
                    intent.putExtra(s, uri.getQueryParameter(s));
                }
            }
            return intent;
        }
        return new Intent();
    }

    public static void start(Context ctx, String url) {
        Intent intent = invoke(ctx, url);
        if (intent.getData() != null){
            ctx.startActivity(intent);
        }
    }
}
