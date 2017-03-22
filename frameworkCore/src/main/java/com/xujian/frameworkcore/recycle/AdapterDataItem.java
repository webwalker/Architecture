package com.xujian.frameworkcore.recycle;

public class AdapterDataItem {
    public int viewType;
    public int subViewType;
    public int position;
    public boolean isSelected = false;
    private Object data;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public AdapterDataItem(int type, Object data) {
        this.viewType = type;
        this.data = data;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public String toString() {
        return "AdapterDataItem{" +
                "type=" + viewType +
                ", data=" + data +
                '}';
    }
}
