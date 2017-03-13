package com.xujian.frameworkcore.model;

/**
 * Created by xujian on 2017/3/9.
 */
public class MessageEvent {
    public int type;
    public Object data;

    public MessageEvent() {
    }

    public MessageEvent(int type) {
        this.type = type;
    }

    public MessageEvent(int type, Object data) {
        this.type = type;
        this.data = type;
    }

    public static MessageEvent newInstance(int type) {
        return new MessageEvent(type);
    }

    public static MessageEvent newInstance(int type, Object data) {
        return new MessageEvent(type, data);
    }
}
