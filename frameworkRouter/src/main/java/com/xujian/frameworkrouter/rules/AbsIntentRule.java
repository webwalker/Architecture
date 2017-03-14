package com.xujian.frameworkrouter.rules;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.Set;

/**
 * 返回Intent的路由规则的基类<br />
 * Created by xujian on 2017/3/10.
 */
public abstract class AbsIntentRule<T> extends AbsRule<T> implements Rule<T, Intent> {
    /**
     * 这里添加不带上参数
     */
    @Override
    public void addRouter(String pattern, Class<T> klass) {
        intentRules.put(getPattern(pattern), klass);
    }

    /**
     * 调用时可以带上参数，参数会拓传到目标对象
     */
    @Override
    public Intent invoke(Context ctx, String pattern) {
        Uri uri = Uri.parse(pattern);
        Class<T> klass = intentRules.get(getPattern(uri));
        if (klass == null) {
            throwException(pattern);
        }
        //存在查询参数时
        Intent intent = new Intent(ctx, klass);
        Set<String> names = uri.getQueryParameterNames();
        if (names != null && names.size() > 0) {
            for (String s : names) {
                intent.putExtra(s, uri.getQueryParameter(s));
            }
        }
        //目标对象可通过以下方式获得参数值
        //RouteParams route = RouteParams.newInstance(uri);
        //route.getValue("")
        intent.setData(uri);
        return intent;
    }

    @Override
    public boolean resolveRule(String pattern) {
        return intentRules.get(getPattern(pattern)) != null;
    }
}