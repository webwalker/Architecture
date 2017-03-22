package com.xujian.bizcommon;

import com.xujian.frameworkcore.model.MessageEvent;

/**
 * 定义全局消息类型，统一管理
 * Created by xujian on 2017/3/19.
 */
public class MessageType {
    public static final int TEST = 0;

    public static boolean canReceive(MessageEvent event, int type) {
        if (event == null || event.type != type) return false;
        return true;
    }
}
